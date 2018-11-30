package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ChampionStats {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double baseHealth;
    Double healthPerLevel;
    Double baseMana;
    Double manaPerLevel;
    Double baseMovementSpeed;
    Double baseArmor;
    Double armorPerLevel;
    Double baseMagicResist;
    Double magicResistPerLevel;
    Double baseAttackRange;
    Double baseHealthRegen;
    Double healthRegenPerLevel;
    Double baseManaRegen;
    Double manaRegenPerLevel;
    Double baseCriticalStrikeChance;
    Double criticalStrikeChancePerLevel;
    Double baseAttackDamage;
    Double attackDamagePerLevel;
    Double baseAttackSpeed;
    Double attackSpeedPerLevel;
}
