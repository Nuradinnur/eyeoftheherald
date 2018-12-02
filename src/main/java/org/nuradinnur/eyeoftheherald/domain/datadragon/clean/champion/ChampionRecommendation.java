package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Maps;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ChampionRecommendation {
    @Id
    @Column(length = 100)
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
