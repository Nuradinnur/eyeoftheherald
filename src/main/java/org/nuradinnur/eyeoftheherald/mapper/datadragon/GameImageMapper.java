package org.nuradinnur.eyeoftheherald.mapper.datadragon;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameImage;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;
import org.springframework.stereotype.Component;

@Component
public class GameImageMapper {

    public GameImage map(GameSpriteDTO dto) {
        if (dto == null) {
            return null;
        }
        val result = new GameImage();
        result.setFileName(dto.getFull());
        result.setSpriteSheetFileName(dto.getSprite());
        result.setSpriteGroup(dto.getGroup());
        result.setOffsetX(dto.getX());
        result.setOffsetY(dto.getY());
        result.setWidth(dto.getW());
        result.setHeight(dto.getH());
        return result;
    }
}
