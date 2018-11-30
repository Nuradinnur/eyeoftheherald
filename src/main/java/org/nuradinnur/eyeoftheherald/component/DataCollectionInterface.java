package org.nuradinnur.eyeoftheherald.component;

import lombok.val;
import org.nuradinnur.eyeoftheherald.component.ratelimiter.RateLimiter;
import org.nuradinnur.eyeoftheherald.configuration.DataAccessConfiguration;
import org.nuradinnur.eyeoftheherald.constant.Endpoints;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@Component
@SuppressWarnings("unchecked")
public class DataCollectionInterface {

    private final Logger logger;
    private final DataAccessConfiguration properties;
    private final RateLimiter rateLimiter;
    private final RestTemplate rest;

    public DataCollectionInterface(DataAccessConfiguration properties, RateLimiter rateLimiter, RestTemplate rest) {
        this.properties = properties;
        this.rateLimiter = rateLimiter;
        this.rest = rest;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public <T> T makeRequest(Regions region, Endpoints endpoint, Map<String, String> pathParameters,
                             MultiValueMap<String, String> queryParameters, ParameterizedTypeReference<T> reference) {
        val uri = getRequestUri(endpoint, pathParameters, queryParameters);
        rateLimiter.acquire(region, endpoint);
        val response = this.rest.exchange(uri, HttpMethod.GET, null, reference);
        rateLimiter.update(region, endpoint, response.getHeaders());
        return response.getBody();
    }

    private URI getRequestUri(Endpoints endpoint, Map<String, String> pathParameters, MultiValueMap<String, String> queryParameters) {
        if (queryParameters == null) {
            queryParameters = new LinkedMultiValueMap<>();
        }
        String uriPrefix;
        if (endpoint != Endpoints.GAME_VERSIONS && endpoint != Endpoints.STATIC_DATA_TARBALL) {
            queryParameters.put("api_key", Collections.singletonList(properties.getKey()));
            uriPrefix = properties.getGameDataUriPrefix();
        } else {
            uriPrefix = properties.getDataDragonUriPrefix();
        }
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(uriPrefix)
                .path(endpoint.getPattern())
                .queryParams(queryParameters)
                .buildAndExpand(pathParameters)
                .toUri();
    }
}
