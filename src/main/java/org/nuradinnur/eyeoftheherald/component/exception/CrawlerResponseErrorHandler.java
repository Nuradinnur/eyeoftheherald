package org.nuradinnur.eyeoftheherald.component.exception;

import org.nuradinnur.eyeoftheherald.component.ShutdownHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class CrawlerResponseErrorHandler implements ResponseErrorHandler {

    private final Logger logger;
    private final ShutdownHook shutdownHook;

    public CrawlerResponseErrorHandler(ShutdownHook shutdownHook) {
        this.shutdownHook = shutdownHook;
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().is4xxClientError()
            || clientHttpResponse.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        switch (clientHttpResponse.getStatusCode()) {
            case UNAUTHORIZED:
            case FORBIDDEN:
            case UNSUPPORTED_MEDIA_TYPE:
                logger.error("FATAL error with response code: {} ({})",
                        clientHttpResponse.getStatusCode().value(),
                        clientHttpResponse.getStatusText().toUpperCase());
                shutdownHook.shutdownGracefully();
            case BAD_REQUEST:
            case NOT_FOUND:
                logger.debug("Response code: {} ({})",
                        clientHttpResponse.getStatusCode().value(),
                        clientHttpResponse.getStatusText().toUpperCase());
                break;
            case TOO_MANY_REQUESTS:
                logger.warn("Exceptional response code: {} ({})",
                        clientHttpResponse.getStatusCode().value(),
                        clientHttpResponse.getStatusText().toUpperCase());
                break;
            case INTERNAL_SERVER_ERROR:
            case SERVICE_UNAVAILABLE:
                logger.warn("Game data servers returned error code: {} ({})",
                        clientHttpResponse.getStatusCode().value(),
                        clientHttpResponse.getStatusText().toUpperCase());
                break;
            default:
                logger.error("Unexpected response code: {} ({})",
                        clientHttpResponse.getStatusCode().value(),
                        clientHttpResponse.getStatusText().toUpperCase());
                        shutdownHook.shutdownGracefully();
        }
    }
}
