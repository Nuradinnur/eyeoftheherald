package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionSpell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonProperty("id")
    String unformattedName;
    @JsonProperty("name")
    String formattedName;
    String description;
    String toolTip;
    String costType;
    String resource;
    @OneToOne(cascade = CascadeType.ALL)
    LevelTip levelTips;
    @ElementCollection
    List<Double> spellRange;
    @ElementCollection
    List<Double> cooldown;
    @ElementCollection
    List<Integer> cost;
    Integer maxRank;
    Integer maxCharges;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionSpellEffect> effects;
    @OneToOne(cascade = CascadeType.ALL)
    SpellVars spellVars;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
}
