package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;

@Data
public class ChampionPassiveDTO {
    private String name;
    private String description;
    private GameSpriteDTO image;
}
