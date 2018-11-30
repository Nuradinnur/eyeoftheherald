package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionRecommendation {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String champion;
    String title;
    String map;
    String mode;
    String type;
    String customTag;
    Integer sortRank;
    Boolean extensionPage;
    @OneToMany(cascade = CascadeType.ALL)
    List<ChampionRecommendationBlock> blocks;
}
