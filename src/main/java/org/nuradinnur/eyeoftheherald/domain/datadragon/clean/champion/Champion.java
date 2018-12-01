package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Champion {
    @Id
    Integer id;
    String unformattedName;
    String formattedName;
    String title;
    String blurb;
    String lore;
    String resource;
    @ElementCollection
    List<String> tipsForAllies;
    @ElementCollection
    List<String> tipsForEnemies;
    @ElementCollection
    List<String> roles;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
    @OneToOne(cascade = CascadeType.ALL)
    ChampionRating rating;
    @OneToOne(cascade = CascadeType.ALL)
    ChampionStats stats;
    @OneToOne(cascade = CascadeType.ALL)
    ChampionPassive passive;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionSpell> spells;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionSkin> skins;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionRecommendation> recommendations;
}

