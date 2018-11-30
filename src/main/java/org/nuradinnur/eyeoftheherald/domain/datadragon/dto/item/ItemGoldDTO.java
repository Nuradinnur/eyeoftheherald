package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item;

import lombok.Data;

@Data
public class ItemGoldDTO {
    private Integer base;
    private Boolean purchasable;
    private Integer total;
    private Integer sell;
}
