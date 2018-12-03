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
    private String formattedName;
    private String unformattedName;
    private String description;
    private String toolTip;
    private String costType;
    private String resource;
    @OneToOne(cascade = CascadeType.ALL)
    private SpellRankUpgrades rankUpgrades;
    @ElementCollection
    private List<Double> spellRangeByRank;
    @ElementCollection
    private List<Double> cooldownByRank;
    @ElementCollection
    private List<Integer> costByRank;
    private Integer maxRank;
    private Integer maxCharges;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SpellEffect> spellEffects;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SpellVars> spellVariables;
    @OneToOne(cascade = CascadeType.ALL)
    private GameImage image;
}
