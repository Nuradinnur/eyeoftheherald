package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ItemsDTO {
    private String type;
    private String version;
    private ItemDTO basic;
    private Map<Integer, ItemDTO> data;
    private List<ItemGroupDTO> groups;
    private List<ItemTreeDTO> tree;
}
