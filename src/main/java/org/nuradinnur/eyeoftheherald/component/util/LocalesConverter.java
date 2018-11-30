package org.nuradinnur.eyeoftheherald.component.util;

import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocalesConverter implements Converter<String, Locales> {

    @Override
    public Locales convert(String name) {
        return Locales.valueOf(name.toUpperCase());
    }
}
