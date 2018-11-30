package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Value;

import java.util.Map;

@Value
public class Champions {
    Map<Integer, Champion> data;
}