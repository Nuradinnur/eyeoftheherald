package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.ItemStats;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameImage;

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
    String summary;
    Integer specialRecipeItem;
    String requiredChampion;
    String requiredAlly;
    Integer buildDepth;
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
    GameImage image;
    Boolean purchasable;
    Integer upgradePrice;
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
}
