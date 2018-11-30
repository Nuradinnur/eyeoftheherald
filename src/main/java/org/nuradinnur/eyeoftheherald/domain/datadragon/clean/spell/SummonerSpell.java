package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.SpellVars;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SummonerSpell {
    @Id
    Integer spellId;
    String id;
    String name;
    String description;
    String toolTip;
    @ElementCollection
    List<String> modes;
    Integer summonerLevel;
    Integer maxRank;
    Integer maxCharges;
    Integer spellRange;
    Integer cooldown;
    Integer cost;
    String costType;
    String resource;
    @OneToMany(cascade = CascadeType.ALL)
    List<SummonerSpellEffect> effects;
    @OneToOne(cascade = CascadeType.ALL)
    SpellVars spellVars;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
}