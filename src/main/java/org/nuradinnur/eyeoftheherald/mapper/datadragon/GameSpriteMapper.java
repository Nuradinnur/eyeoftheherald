package org.nuradinnur.eyeoftheherald.mapper.datadragon;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;
import org.springframework.stereotype.Component;

@Component
public class GameSpriteMapper {

    public GameSprite map(GameSpriteDTO dto) {
        if (dto == null) {
            return null;
        }
        val result = new GameSprite();
        result.setSuggestedFileName(dto.getFull());
        result.setSpriteSheetFileName(dto.getSprite());
        result.setSpriteGroup(dto.getGroup());
        result.setOffsetX(dto.getX());
        result.setOffsetY(dto.getY());
        result.setWidth(dto.getW());
        result.setHeight(dto.getH());
        return result;
    }
}
