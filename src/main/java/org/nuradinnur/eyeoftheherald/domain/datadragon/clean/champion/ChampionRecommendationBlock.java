package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionRecommendationBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
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
