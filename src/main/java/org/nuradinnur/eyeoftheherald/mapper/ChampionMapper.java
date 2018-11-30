package org.nuradinnur.eyeoftheherald.mapper;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.Champion;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.ChampionDTO;
import org.springframework.stereotype.Component;

@Component
public class ChampionMapper {

    public Champion map(ChampionDTO dto) {
        val result = new Champion();
        result.setUnformattedName(dto.getId());
        result.setFormattedName(dto.getName());
        result.setTitle(dto.getTitle());
        result.setBlurb(dto.getBlurb());
        result.setLore(dto.getLore());
        result.setResource(dto.getPartype());
        result.setTipsForAllies(dto.getAllytips());
        result.setTipsForEnemies(dto.getEnemytips());
        result.setRoles(dto.getTags());

        return result;
    }
//    @Mappings({
//            @Mapping(target = "baseHealth", source = "dto.hp"),
//            @Mapping(target = "healthPerLevel", source = "dto.hpperlevel"),
//            @Mapping(target = "baseMana", source = "dto.mp"),
//            @Mapping(target = "manaPerLevel", source = "dto.mpperlevel"),
//            @Mapping(target = "baseMovementSpeed", source = "dto.movespeed"),
//            @Mapping(target = "baseArmor", source = "dto.armor"),
//            @Mapping(target = "armorPerLevel", source = "dto.armorperlevel"),
//            @Mapping(target = "baseMagicResist", source = "dto.spellblock"),
//            @Mapping(target = "magicResistPerLevel", source = "dto.spellblockperlevel"),
//            @Mapping(target = "baseAttackRange", source = "dto.attackrange"),
//            @Mapping(target = "baseHealthRegen", source = "dto.hpregen"),
//            @Mapping(target = "healthRegenPerLevel", source = "dto.hpregenperlevel"),
//            @Mapping(target = "baseManaRegen", source = "dto.mpregen"),
//            @Mapping(target = "manaRegenPerLevel", source = "dto.mpregenperlevel"),
//            @Mapping(target = "baseCriticalStrikeChance", source = "dto.crit"),
//            @Mapping(target = "criticalStrikeChancePerLevel", source = "dto.critperlevel"),
//            @Mapping(target = "baseAttackDamage", source = "dto.attackdamage"),
//            @Mapping(target = "attackDamagePerLevel", source = "dto.attackdamageperlevel"),
//            @Mapping(target = "baseAttackSpeed", source = "dto.attackspeedperlevel"),
//            @Mapping(target = "attackSpeedPerLevel", source = "dto.attackspeed")
//    })
//    ChampionStats mapChampionStats(ChampionStatsDTO dto);
//    LevelTip mapLevelTip(LevelTipDTO dto);
}