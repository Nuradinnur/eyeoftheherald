package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameImage;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Champion {
    @Id
    private Integer id;
    private String unformattedName;
    private String formattedName;
    private String title;
    private String blurb;
    private String lore;
    private String resource;
    @ElementCollection
    private List<String> tipsForAllies;
    @ElementCollection
    private List<String> tipsForEnemies;
    @ElementCollection
    private List<String> roles;
    @OneToOne(cascade = CascadeType.ALL)
    private GameImage image;
    @OneToOne(cascade = CascadeType.ALL)
    private ChampionRating rating;
    @OneToOne(cascade = CascadeType.ALL)
    private ChampionStats stats;
    @OneToOne(cascade = CascadeType.ALL)
    private ChampionPassive passive;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ChampionSpell> spells;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ChampionSkin> skins;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ChampionRecommendation> recommendations;
}

