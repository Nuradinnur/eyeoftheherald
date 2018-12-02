package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameImage;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellEffect;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionSpell {
    @Id
    @Column(length = 100)
    String formattedName;
    String unformattedName;
    String description;
    String toolTip;
    String costType;
    String resource;
    @OneToOne(cascade = CascadeType.ALL)
    SpellRankUpgrades rankUpgrades;
    @ElementCollection
    List<Double> spellRangeByRank;
    @ElementCollection
    List<Double> cooldownByRank;
    @ElementCollection
    List<Integer> costByRank;
    Integer maxRank;
    Integer maxCharges;
    @OneToMany(cascade = CascadeType.ALL)
    List<SpellEffect> spellEffects;
    @OneToMany(cascade = CascadeType.ALL)
    List<SpellVars> spellVariables;
    @OneToOne(cascade = CascadeType.ALL)
    GameImage image;
}
