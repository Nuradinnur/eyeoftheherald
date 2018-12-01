package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionSpell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    String unformattedName;
    String formattedName;
    String description;
    String toolTip;
    String costType;
    String resource;
    @OneToOne(cascade = CascadeType.ALL)
    LevelTips levelTips;
    @ElementCollection
    List<Double> spellRanges;
    @ElementCollection
    List<Double> cooldowns;
    @ElementCollection
    List<Integer> costs;
    Integer maxRank;
    Integer maxCharges;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionSpellEffect> effects;
    @OneToMany(cascade = CascadeType.ALL)
    List<SpellVars> spellVars;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
}
