package org.nuradinnur.eyeoftheherald.component.util;

import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RegionsConverter implements Converter<String, Regions> {

    @Override
    public Regions convert(String name) {
        return Regions.valueOf(name.toUpperCase());
    }
}