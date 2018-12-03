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
    private String title;
    private Maps map;
    private String mode;
    private String type;
    private String customTag;
    private Integer sortRank;
    private Boolean extensionPage;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ChampionRecommendationBlock> blocks;
}
