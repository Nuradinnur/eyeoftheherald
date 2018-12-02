package org.nuradinnur.eyeoftheherald.mapper.datadragon;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellEffect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpellEffectsMapper {

    public SpellEffect map(List<Double> effect) {
        val result = new SpellEffect();
        result.setEffects(effect);
        return result;
    }
}
