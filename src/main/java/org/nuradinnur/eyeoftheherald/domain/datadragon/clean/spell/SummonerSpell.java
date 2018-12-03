package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameImage;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellEffect;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SummonerSpell {
    @Id
    private Integer id;
    private String unformattedName;
    private String formattedName;
    private String description;
    private String toolTip;
    @ElementCollection
    private List<String> modes;
    private Integer summonerLevel;
    private Integer maxRank;
    private Integer maxCharges;
    @ElementCollection
    private List<Integer> spellRangeByRank;
    @ElementCollection
    private List<Integer> cooldownByRank;
    @ElementCollection
    private List<Integer> costByRank;
    private String costType;
    private String resource;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SpellEffect> effects;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SpellVars> toolTipVariables;
    @OneToOne(cascade = CascadeType.ALL)
    private GameImage image;
}
