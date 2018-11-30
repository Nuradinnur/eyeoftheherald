package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class Runes {
    List<RunePath> paths;
    Map<Integer, Rune> data;
}
