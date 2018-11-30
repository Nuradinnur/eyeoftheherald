package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionRecommendationBlock {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String type;
    private Boolean recMath;
    private Boolean recSteps;
    private Integer minSummonerLevel;
    private Integer maxSummonerLevel;
    private String showIfSummonerSpell;
    private String hideIfSummonerSpell;
    private String appendAfterSection;
    @ElementCollection
    private List<String> visibleWithAllOf;
    @ElementCollection
    private List<String> hiddenWithAnyOf;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ChampionRecommendationBlockItem> items;
}
