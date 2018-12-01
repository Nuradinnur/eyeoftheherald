package org.nuradinnur.eyeoftheherald.mapper.datadragon.spell;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell.SummonerSpell;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell.SummonerSpellEffect;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.GameSpriteMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.SpellVarsMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SummonerSpellMapper {

    private final SpellVarsMapper spellVarsMapper;
    private final GameSpriteMapper gameSpriteMapper;

    public SummonerSpellMapper(SpellVarsMapper spellVarsMapper, GameSpriteMapper gameSpriteMapper) {
        this.spellVarsMapper = spellVarsMapper;
        this.gameSpriteMapper = gameSpriteMapper;
    }

    public List<SummonerSpell> mapAll(List<SummonerSpellDTO> dtos) {
        return dtos.stream().map(this::map).collect(Collectors.toList());
    }

    public SummonerSpell map(SummonerSpellDTO dto) {
        val result = new SummonerSpell();
        result.setSpellId(dto.getKey());
        result.setUnformattedName(dto.getId());
        result.setFormattedName(dto.getName());
        result.setDescription(dto.getDescription());
        result.setToolTip(dto.getTooltip());
        result.setModes(dto.getModes());
        result.setSummonerLevel(dto.getSummonerLevel());
        result.setMaxRank(dto.getMaxrank());
        result.setMaxCharges(dto.getMaxammo());
        result.setSpellRangeByRank(dto.getRange());
        result.setCooldownByRank(dto.getCooldown());
        result.setCostByRank(dto.getCost());
        result.setCostType(dto.getCostType());
        result.setResource(dto.getResource());
        val effects = dto.getEffect().stream().map(this::map).collect(Collectors.toList());
        result.setEffects(effects);
        val spellVars = dto.getVars().stream().map(spellVarsMapper::map).collect(Collectors.toList());
        result.setSpellVars(spellVars);
        result.setSprite(gameSpriteMapper.map(dto.getImage()));
        return result;
    }

    private SummonerSpellEffect map(List<Double> effect) {
        val result = new SummonerSpellEffect();
        result.setEffects(effect);
        return result;
    }
}
