package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SummonerSpell {
    @Id
    Integer spellId;
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
    List<SummonerSpellEffect> effects;
    @OneToMany(cascade = CascadeType.ALL)
    List<SpellVars> spellVars;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
}
