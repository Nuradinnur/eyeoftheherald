package org.nuradinnur.eyeoftheherald.mapper.datadragon.item;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.ItemStats;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item.Item;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item.ItemDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.GameSpriteMapper;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    private final GameSpriteMapper gameSpriteMapper;

    public ItemMapper(GameSpriteMapper gameSpriteMapper) {
        this.gameSpriteMapper = gameSpriteMapper;
    }

    public List<Item> mapAll(List<ItemDTO> dtos) {
        return dtos.stream().map(this::map).collect(Collectors.toList());
    }

    public Map<ItemStats, Double> map(Map<String, Double> stats) {
        val result = new HashMap<ItemStats, Double>();
        for (val key : stats.keySet()) {
            result.put(ItemStats.getByValue(key), stats.get(key));
        }
        return result;
    }

    public Item map(ItemDTO dto) {
        val result = new Item();
        result.setId(dto.getId());
        result.setName(dto.getName());
        result.setColloquialisms(Arrays.asList(dto.getColloq().split(";")));
        result.setDescription(dto.getDescription());
        result.setPlaintext(dto.getPlaintext());
        result.setSpecialRecipeItem(dto.getSpecialRecipe());
        result.setRequiredChampion(dto.getRequiredChampion());
        result.setRequiredAlly(dto.getRequiredAlly());
        result.setUpgrades(dto.getInto());
        result.setIngredients(dto.getFrom());
        result.setMaxPurchasable(dto.getStacks());
        result.setConsumable(dto.getConsumed());
        result.setConsumableAtFull(dto.getConsumeOnFull());
        result.setAvailableInStore(dto.getInStore());
        result.setGenerallyUnavailable(dto.getHideFromAll());
        result.setSprite(gameSpriteMapper.map(dto.getImage()));
        result.setBuyPrice(dto.getGold().getBase());
        result.setPurchasable(dto.getGold().getPurchasable());
        result.setTotalPrice(dto.getGold().getTotal());
        result.setSellPrice(dto.getGold().getSell());
        result.setTags(dto.getTags());
        result.setMapsAvailableOn(dto.getMaps());
        val stats = map(dto.getStats());
        result.setStats(stats);
        val effects = new ArrayList<Double>();
        if (dto.getEffect() != null) {
            effects.addAll(dto.getEffect().values());
        }
        result.setEffects(effects);
        result.setBuildDepth(dto.getDepth());
        return result;
    }
}
