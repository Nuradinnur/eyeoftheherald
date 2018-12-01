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
    Long id;
    String type;
    Boolean recMath;
    Boolean recSteps;
    Integer minSummonerLevel;
    Integer maxSummonerLevel;
    String showIfSummonerSpell;
    String hideIfSummonerSpell;
    String appendAfterSection;
    @ElementCollection
    List<String> visibleWithAllOf;
    @ElementCollection
    List<String> hiddenWithAnyOf;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionRecommendationBlockItem> items;
}
