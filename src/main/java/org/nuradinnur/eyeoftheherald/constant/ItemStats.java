package org.nuradinnur.eyeoftheherald.constant;

public enum ItemStats {
    FLAT_ARMOR("FlatArmorMod"),
    FLAT_ATTACK_SPEED("FlatAttackSpeedMod"),
    FLAT_BLOCK("FlatBlockMod"),
    FLAT_CRIT_CHANCE("FlatCritChanceMod"),
    FLAT_CRIT_DAMAGE("FlatCritDamageMod"),
    FLAT_EXPERIENCE_BONUS("FlatEXPBonus"),
    FLAT_ENERGY("FlatEnergyPoolMod"),
    FLAT_ENERGY_REGEN("FlatEnergyRegenMod"),
    FLAT_HEALTH("FlatHPPoolMod"),
    FLAT_HEALTH_REGEN("FlatHPRegenMod"),
    FLAT_MANA("FlatMPPoolMod"),
    FLAT_MANA_REGEN("FlatMPRegenMod"),
    FLAT_ABILITY_POWER("FlatMagicDamageMod"),
    FLAT_MOVEMENT_SPEED("FlatMovementSpeedMod"),
    FLAT_ATTACK_DAMAGE("FlatPhysicalDamageMod"),
    FLAT_MAGIC_RESIST("FlatSpellBlockMod"),
    PERCENT_ARMOR("PercentArmorMod"),
    PERCENT_ATTACK_SPEED("PercentAttackSpeedMod"),
    PERCENT_BLOCK("PercentBlockMod"),
    PERCENT_CRIT_CHANCE("PercentCritChanceMod"),
    PERCENT_CRIT_DAMAGE("PercentCritDamageMod"),
    PERCENT_DODGE_MOD("PercentDodgeMod"),
    PERCENT_EXPERIENCE_BONUS("PercentEXPBonus"),
    PERCENT_HEALTH("PercentHPPoolMod"),
    PERCENT_HEALTH_REGEN("PercentHPRegenMod"),
    PERCENT_LIFE_STEAL("PercentLifeStealMod"),
    PERCENT_MANA("PercentMPPoolMod"),
    PERCENT_MANA_REGEN("PercentMPRegenMod"),
    PERCENT_ABILITY_POWER("PercentMagicDamageMod"),
    PERCENT_MOVEMENT_SPEED("PercentMovementSpeedMod"),
    PERCENT_ATTACK_DAMAGE("PercentPhysicalDamageMod"),
    PERCENT_MAGIC_RESIST("PercentSpellBlockMod"),
    PERCENT_SPELL_VAMP("PercentSpellVampMod");

    private String key;

    ItemStats(String key) {
        this.key = key;
    }
}
