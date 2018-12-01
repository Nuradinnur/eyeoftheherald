package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Maps;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    String title;
    Maps map;
    String mode;
    String type;
    String customTag;
    Integer sortRank;
    Boolean extensionPage;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionRecommendationBlock> blocks;
}
