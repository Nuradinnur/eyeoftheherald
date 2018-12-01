package org.nuradinnur.eyeoftheherald.component.util;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocalesConverter implements Converter<String, Locales> {

    private final Map<String, Locales> lookupTable;

    public LocalesConverter() {
        lookupTable = new HashMap<>();
        for (val locale : Locales.values()) {
            lookupTable.put(locale.getIdentifier(), locale);
        }
    }

    @Override
    public Locales convert(String name) {
        return lookupTable.get(name);
    }
}
