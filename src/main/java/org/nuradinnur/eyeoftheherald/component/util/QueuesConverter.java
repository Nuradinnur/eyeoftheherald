package org.nuradinnur.eyeoftheherald.component.util;

import org.nuradinnur.eyeoftheherald.constant.Queues;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QueuesConverter implements Converter<String, Queues> {

    @Override
    public Queues convert(String name) {
        return Queues.valueOf(name.toUpperCase());
    }
}
