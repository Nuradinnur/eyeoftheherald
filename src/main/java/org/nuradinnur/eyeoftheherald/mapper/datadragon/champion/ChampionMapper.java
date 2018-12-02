package org.nuradinnur.eyeoftheherald.mapper.datadragon.champion;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellEffect;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.*;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.*;
import org.nuradinnur.eyeoftheherald.mapper.MapsMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.GameImageMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.SpellVariablesMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChampionMapper {

    private final GameImageMapper gameImageMapper;
    private final SpellVariablesMapper spellVariablesMapper;
    private final MapsMapper mapsMapper;

    public ChampionMapper(GameImageMapper gameImageMapper, SpellVariablesMapper spellVariablesMapper, MapsMapper mapsMapper) {
        this.gameImageMapper = gameImageMapper;
        this.spellVariablesMapper = spellVariablesMapper;
        this.mapsMapper = mapsMapper;
    }

    public List<Champion> mapAll(List<ChampionDTO> dto) {
        return dto.stream().map(this::map).collect(Collectors.toList());
    }

    public Champion map(ChampionDTO dto) {
        val result = new Champion();
        result.setId(dto.getKey());
        result.setUnformattedName(dto.getId());
        result.setFormattedName(dto.getName());
        result.setTitle(dto.getTitle());
        result.setBlurb(dto.getBlurb());
        result.setLore(dto.getLore());
        result.setResource(dto.getPartype());
        result.setTipsForAllies(dto.getAllytips());
        result.setTipsForEnemies(dto.getEnemytips());
        result.setRoles(dto.getTags());
        result.setImage(gameImageMapper.map(dto.getImage()));
        result.setRating(map(dto.getInfo(), result.getId()));
        result.setStats(map(dto.getStats(), result.getId()));
        result.setPassive(map(dto.getPassive()));
        val spells = dto.getSpells().stream().map(this::map).collect(Collectors.toList());
        result.setSpells(spells);
        val skins = dto.getSkins().stream().map(skin -> map(skin, result.getUnformattedName())).collect(Collectors.toList());
        result.setSkins(skins);
        val recommendations = dto.getRecommended().stream().map(this::map).collect(Collectors.toList());
        result.setRecommendations(recommendations);
        return result;
    }

    private ChampionRating map(ChampionInfoDTO dto, Integer championId) {
        val result = new ChampionRating();
        result.setId(championId);
        result.setAttack(dto.getAttack());
        result.setDefense(dto.getDefense());
        result.setMagic(dto.getMagic());
        result.setDifficulty(dto.getDifficulty());
        return result;
    }

    private ChampionStats map(ChampionStatsDTO dto, Integer championId) {
        val result = new ChampionStats();
        result.setId(championId);
        result.setBaseHealth(dto.getHp());
        result.setHealthPerLevel(dto.getHpperlevel());
        result.setBaseMana(dto.getMp());
        result.setManaPerLevel(dto.getMpperlevel());
        result.setBaseMovementSpeed(dto.getMovespeed());
        result.setBaseArmor(dto.getArmor());
        result.setArmorPerLevel(dto.getArmorperlevel());
        result.setBaseMagicResist(dto.getSpellblock());
        result.setMagicResistPerLevel(dto.getSpellblockperlevel());
        result.setBaseAttackRange(dto.getAttackrange());
        result.setBaseHealthRegen(dto.getHpregen());
        result.setHealthRegenPerLevel(dto.getHpregenperlevel());
        result.setBaseManaRegen(dto.getMpregen());
        result.setManaRegenPerLevel(dto.getMpregenperlevel());
        result.setBaseCriticalStrikeChance(dto.getCrit());
        result.setCriticalStrikeChancePerLevel(dto.getCritperlevel());
        result.setBaseAttackDamage(dto.getAttackdamage());
        result.setAttackDamagePerLevel(dto.getAttackdamageperlevel());
        result.setBaseAttackSpeed(dto.getAttackspeed());
        result.setAttackSpeedPerLevel(dto.getAttackspeedperlevel());
        return result;
    }

    private ChampionPassive map(ChampionPassiveDTO dto) {
        val result = new ChampionPassive();
        result.setName(dto.getName());
        result.setDescription(dto.getDescription());
        result.setImage(gameImageMapper.map(dto.getImage()));
        return result;
    }

    private SpellRankUpgrades map(LevelTipsDTO dto, String spellName) {
        val result = new SpellRankUpgrades();
        result.setForSpell(spellName);
        if (dto == null) {
            result.setLabel(Collections.emptyList());
            result.setEffect(Collections.emptyList());
        }
        else {
            result.setLabel(dto.getLabel());
            result.setEffect(dto.getEffect());
        }
        return result;
    }

    private SpellEffect map(List<Double> dto) {
        val result = new SpellEffect();
        result.setEffects(dto);
        return result;
    }

    private ChampionSpell map(ChampionSpellDTO dto) {
        val result = new ChampionSpell();
        result.setFormattedName(dto.getName());
        result.setUnformattedName(dto.getId());
        result.setDescription(dto.getDescription());
        result.setToolTip(dto.getTooltip());
        result.setCostType(dto.getCostType().trim());
        result.setResource(dto.getResource());
        result.setRankUpgrades(map(dto.getLeveltip(), result.getFormattedName()));
        result.setSpellRangeByRank(dto.getRange());
        result.setCooldownByRank(dto.getCooldown());
        result.setCostByRank(dto.getCost());
        result.setMaxRank(dto.getMaxrank());
        result.setMaxCharges(dto.getMaxammo());
        val effects = dto.getEffect().stream().map(this::map).collect(Collectors.toList());
        result.setSpellEffects(effects);
        val spellVars = dto.getVars().stream().map(spellVariablesMapper::map).collect(Collectors.toList());
        result.setSpellVariables(spellVars);
        result.setImage(gameImageMapper.map(dto.getImage()));
        return result;
    }

    private ChampionSkin map(ChampionSkinDTO dto, String championName) {
        val result = new ChampionSkin();
        result.setId(dto.getId());
        result.setName(dto.getName());
        result.setSkinIndex(dto.getNum());
        result.setHasChromas(dto.getChromas());
        result.setImageFileName(championName + "_" + result.getSkinIndex() + ".jpg");
        return result;
    }

    private ChampionRecommendationBlockItem map(ChampionRecommendationBlockItemDTO dto) {
        val result = new ChampionRecommendationBlockItem();
        result.setId(Integer.parseInt(dto.getId()));
        result.setQuantity(dto.getCount());
        result.setHideQuantity(dto.getHideCount());
        return result;
    }

    private ChampionRecommendationBlock map(ChampionRecommendationBlockDTO dto) {
        val result = new ChampionRecommendationBlock();
        result.setType(dto.getType());
        result.setRecMath(dto.getRecMath());
        result.setRecSteps(dto.getRecSteps());
        result.setMinSummonerLevel(dto.getMinSummonerLevel());
        result.setMaxSummonerLevel(dto.getMaxSummonerLevel());
        result.setShowIfSummonerSpell(dto.getShowIfSummonerSpell());
        result.setHideIfSummonerSpell(dto.getHideIfSummonerSpell());
        result.setAppendAfterSection(dto.getAppendAfterSection());
        result.setVisibleWithAllOf(dto.getVisibleWithAllOf());
        result.setHiddenWithAnyOf(dto.getHiddenWithAnyOf());
        val items = dto.getItems().stream().map(this::map).collect(Collectors.toList());
        result.setItems(items);
        return result;
    }

    private ChampionRecommendation map(ChampionRecommendationDTO dto) {
        val result = new ChampionRecommendation();
        result.setTitle(dto.getTitle());
        result.setMap(mapsMapper.map(dto.getMap()));
        result.setMode(dto.getMode());
        result.setType(dto.getType());
        result.setCustomTag(dto.getCustomTag());
        result.setSortRank(dto.getSortrank());
        result.setExtensionPage(dto.getExtensionPage());
        val blocks = dto.getBlocks().stream().map(this::map).collect(Collectors.toList());
        result.setBlocks(blocks);
        return result;
    }
}