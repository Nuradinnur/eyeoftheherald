package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChampionRecommendationBlockItem {
    @Id
    private Integer id;
    private Integer quantity;
    private Boolean hideQuantity;
}
