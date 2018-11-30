package org.nuradinnur.eyeoftheherald.domain.datadragon.dto;

import lombok.Data;

import java.util.List;

@Data
public class SpellVarsDTO {
    private String link;
    private List<Double> coeff;
    private String key;
}
