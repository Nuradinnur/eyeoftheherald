package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;

import java.util.List;

@Data
public class LevelTipsDTO {
    private List<String> label;
    private List<String> effect;
}
