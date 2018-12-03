package org.nuradinnur.eyeoftheherald.component.util;

import org.nuradinnur.eyeoftheherald.constant.RankedQueues;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QueuesConverter implements Converter<String, RankedQueues> {

    @Override
    public RankedQueues convert(String name) {
        return RankedQueues.valueOf(name.toUpperCase());
    }
}
