package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChampionStats {
    @Id
    @JsonIgnore
    private Integer id;
    private Double baseHealth;
    private Double healthPerLevel;
    private Double baseMana;
    private Double manaPerLevel;
    private Double baseMovementSpeed;
    private Double baseArmor;
    private Double armorPerLevel;
    private Double baseMagicResist;
    private Double magicResistPerLevel;
    private Double baseAttackRange;
    private Double baseHealthRegen;
    private Double healthRegenPerLevel;
    private Double baseManaRegen;
    private Double manaRegenPerLevel;
    private Double baseCriticalStrikeChance;
    private Double criticalStrikeChancePerLevel;
    private Double baseAttackDamage;
    private Double attackDamagePerLevel;
    private Double baseAttackSpeed;
    private Double attackSpeedPerLevel;
}
