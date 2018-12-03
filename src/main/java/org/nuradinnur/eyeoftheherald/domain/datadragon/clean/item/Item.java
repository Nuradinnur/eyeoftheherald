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
    private Integer id;
    private String name;
    @ElementCollection
    private List<String> colloquialisms;
    private String description;
    private String summary;
    private Integer specialRecipeItem;
    private String requiredChampion;
    private String requiredAlly;
    private Integer buildDepth;
    @ElementCollection
    private List<Integer> upgrades;
    @ElementCollection
    private List<Integer> ingredients;
    private Integer maxPurchasable;
    private Boolean consumable;
    private Boolean consumableAtFull;
    private Boolean availableInStore;
    private Boolean generallyUnavailable;
    @OneToOne(cascade = CascadeType.ALL)
    private GameImage image;
    private Boolean purchasable;
    private Integer upgradePrice;
    private Integer totalPrice;
    private Integer sellPrice;
    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private Map<Integer, Boolean> mapsAvailableOn;
    @ElementCollection
    private Map<ItemStats, Double> stats;
    @ElementCollection
    private List<Double> effects;
}
