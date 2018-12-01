package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.ItemStats;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Item {
    @Id
    Integer id;
    String name;
    @ElementCollection
    List<String> colloquialisms;
    String description;
    String plaintext;
    Integer specialRecipeItem;
    String requiredChampion;
    String requiredAlly;
    @ElementCollection
    List<Integer> upgrades;
    @ElementCollection
    List<Integer> ingredients;
    Integer maxPurchasable;
    Boolean consumable;
    Boolean consumableAtFull;
    Boolean availableInStore;
    Boolean generallyUnavailable;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
    Integer buyPrice;
    Boolean purchasable;
    Integer totalPrice;
    Integer sellPrice;
    @ElementCollection
    List<String> tags;
    @ElementCollection
    Map<Integer, Boolean> mapsAvailableOn;
    @ElementCollection
    Map<ItemStats, Double> stats;
    @ElementCollection
    List<Double> effects;
    Integer buildDepth;
}
