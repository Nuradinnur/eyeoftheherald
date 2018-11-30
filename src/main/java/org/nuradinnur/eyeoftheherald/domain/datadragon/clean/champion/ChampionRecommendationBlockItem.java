package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ChampionRecommendationBlockItem {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String itemId;
    Integer quantity;
    Boolean hideQuantity;
}
