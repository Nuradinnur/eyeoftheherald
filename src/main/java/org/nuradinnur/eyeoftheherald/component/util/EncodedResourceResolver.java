package org.nuradinnur.eyeoftheherald.component.util;

import lombok.val;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolver;

import java.io.IOException;
import java.net.URLDecoder;

@Component
public class EncodedResourceResolver extends PathResourceResolver implements ResourceResolver {


    @Override
    protected Resource getResource(String resourcePath, Resource location) throws IOException {
        val fixedResourcePath = URLDecoder.decode(resourcePath);
        return super.getResource(fixedResourcePath, location);
    }
}