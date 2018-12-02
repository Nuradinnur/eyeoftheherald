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
    Integer id;
    String unformattedName;
    String formattedName;
    String description;
    String toolTip;
    @ElementCollection
    List<String> modes;
    Integer summonerLevel;
    Integer maxRank;
    Integer maxCharges;
    @ElementCollection
    List<Integer> spellRangeByRank;
    @ElementCollection
    List<Integer> cooldownByRank;
    @ElementCollection
    List<Integer> costByRank;
    String costType;
    String resource;
    @OneToMany(cascade = CascadeType.ALL)
    List<SpellEffect> effects;
    @OneToMany(cascade = CascadeType.ALL)
    List<SpellVars> toolTipVariables;
    @OneToOne(cascade = CascadeType.ALL)
    GameImage image;
}
