package org.nuradinnur.eyeoftheherald.mapper;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Maps;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.*;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChampionMapper {

    private final GameSpriteMapper gameSpriteMapper;
    private final SpellVarsMapper spellVarsMapper;

    public ChampionMapper(GameSpriteMapper gameSpriteMapper, SpellVarsMapper spellVarsMapper) {
        this.gameSpriteMapper = gameSpriteMapper;
        this.spellVarsMapper = spellVarsMapper;
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
        result.setSprite(gameSpriteMapper.map(dto.getImage()));
        result.setRating(map(dto.getInfo()));
        result.setStats(map(dto.getStats()));
        result.setPassive(map(dto.getPassive()));
        val spells = dto.getSpells().stream().map(this::map).collect(Collectors.toList());
        result.setSpells(spells);
        val skins = dto.getSkins().stream().map(this::map).collect(Collectors.toList());
        result.setSkins(skins);
        val recommendations = dto.getRecommended().stream().map(this::map).collect(Collectors.toList());
        result.setRecommendations(recommendations);
        return result;
    }

    private ChampionRating map(ChampionInfoDTO dto) {
        val result = new ChampionRating();
        result.setAttack(dto.getAttack());
        result.setDefense(dto.getDefense());
        result.setMagic(dto.getMagic());
        result.setDifficulty(dto.getDifficulty());
        return result;
    }

    private ChampionStats map(ChampionStatsDTO dto) {
        val result = new ChampionStats();
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
        result.setSprite(gameSpriteMapper.map(dto.getImage()));
        return result;
    }

    private LevelTips map(LevelTipsDTO dto) {
        val result = new LevelTips();
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

    private ChampionSpellEffect map(List<Double> dto) {
        val result = new ChampionSpellEffect();
        result.setEffects(dto);
        return result;
    }

    private ChampionSpell map(ChampionSpellDTO dto) {
        val result = new ChampionSpell();
        result.setUnformattedName(dto.getId());
        result.setFormattedName(dto.getName());
        result.setDescription(dto.getDescription());
        result.setToolTip(dto.getTooltip());
        result.setCostType(dto.getCostType());
        result.setResource(dto.getResource());
        result.setLevelTips(map(dto.getLeveltip()));
        result.setSpellRanges(dto.getRange());
        result.setCooldowns(dto.getCooldown());
        result.setCosts(dto.getCost());
        result.setMaxRank(dto.getMaxrank());
        result.setMaxCharges(dto.getMaxammo());
        val effects = dto.getEffect().stream().map(this::map).collect(Collectors.toList());
        result.setEffects(effects);
        val spellVars = dto.getVars().stream().map(spellVarsMapper::map).collect(Collectors.toList());
        result.setSpellVars(spellVars);
        result.setSprite(gameSpriteMapper.map(dto.getImage()));
        return result;
    }

    private ChampionSkin map(ChampionSkinDTO dto) {
        val result = new ChampionSkin();
        result.setName(dto.getName());
        result.setSkinIndex(dto.getNum());
        result.setHasChromas(dto.getChromas());
        return result;
    }

    private Maps mapChampionRecommendationMap(String dto) {
        switch(dto.toUpperCase()) {
            case "SR":
                return Maps.SUMMONERS_RIFT_CURRENT;
            case "HA":
                return Maps.HOWLING_ABYSS;
            case "TT":
                return Maps.TWISTED_TREELINE_CURRENT;
            case "CRYSTALSCAR":
                return Maps.THE_CRYSTAL_SCAR;
            case "CITYPARK":
                return Maps.VALORAN_CITY_PARK;
            case "PROJECTSLUMS":
                return Maps.SUBSTRUCTURE_43;
            case "SL":
                return Maps.NEXUS_BLITZ;
            default:
                return Maps.UNKNOWN;
        }
    }

    private ChampionRecommendationBlockItem map(ChampionRecommendationBlockItemDTO dto) {
        val result = new ChampionRecommendationBlockItem();
        result.setItemId(dto.getId());
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
        result.setMap(mapChampionRecommendationMap(dto.getMap()));
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