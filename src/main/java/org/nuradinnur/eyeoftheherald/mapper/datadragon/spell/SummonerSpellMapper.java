package org.nuradinnur.eyeoftheherald.mapper.datadragon.spell;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell.SummonerSpell;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.GameImageMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.SpellEffectsMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.SpellVariablesMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SummonerSpellMapper {

    private final GameImageMapper gameImageMapper;
    private final SpellEffectsMapper spellEffectsMapper;
    private final SpellVariablesMapper spellVariablesMapper;

    public SummonerSpellMapper(SpellVariablesMapper spellVariablesMapper, GameImageMapper gameImageMapper, SpellEffectsMapper spellEffectsMapper) {
        this.spellVariablesMapper = spellVariablesMapper;
        this.gameImageMapper = gameImageMapper;
        this.spellEffectsMapper = spellEffectsMapper;
    }

    public List<SummonerSpell> mapAll(List<SummonerSpellDTO> dtos) {
        return dtos.stream().map(this::map).collect(Collectors.toList());
    }

    public SummonerSpell map(SummonerSpellDTO dto) {
        val result = new SummonerSpell();
        result.setId(dto.getKey());
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
        val effects = dto.getEffect().stream().map(spellEffectsMapper::map).collect(Collectors.toList());
        result.setEffects(effects);
        val spellVars = dto.getVars().stream().map(spellVariablesMapper::map).collect(Collectors.toList());
        result.setToolTipVariables(spellVars);
        result.setImage(gameImageMapper.map(dto.getImage()));
        return result;
    }
}
