package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;

@Data
public class SummonerIconDTO {
    private Integer id;
    private GameSpriteDTO image;
}
