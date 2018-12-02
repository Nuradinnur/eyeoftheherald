package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChampionRecommendationBlockItem {
    @Id
    Integer id;
    Integer quantity;
    Boolean hideQuantity;
}
