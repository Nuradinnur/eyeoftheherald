package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;

import java.util.List;
import java.util.Map;

@Data
public class ItemDTO {
    private Integer id;
    private String name;
    private String description;
    private String colloq;
    private String plaintext;
    private Integer specialRecipe;
    private String requiredChampion;
    private String requiredAlly;
    private List<Integer> into;
    private List<Integer> from;
    private Integer stacks;
    private Boolean consumed;
    private Boolean consumeOnFull;
    private Boolean inStore;
    private Boolean hideFromAll;
    private GameSpriteDTO image;
    private ItemGoldDTO gold;
    private List<String> tags;
    private Map<Integer, Boolean> maps;
    private Map<String, Double> stats;
    private Map<String, Double> effect;
    private Integer depth;
}
