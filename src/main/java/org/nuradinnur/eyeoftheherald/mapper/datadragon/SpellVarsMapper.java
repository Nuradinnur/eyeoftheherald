package org.nuradinnur.eyeoftheherald.mapper.datadragon;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.SpellVarsDTO;
import org.springframework.stereotype.Component;

@Component
public class SpellVarsMapper {

    public SpellVars map(SpellVarsDTO dto) {
        val result = new SpellVars();
        result.setToolTipLocation(dto.getKey());
        result.setScalingVariable(dto.getLink());
        result.setScalingCoefficients(dto.getCoeff());
        return result;
    }
}
