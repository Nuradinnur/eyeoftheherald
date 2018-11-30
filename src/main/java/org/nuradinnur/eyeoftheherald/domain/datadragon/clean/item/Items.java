package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class Items {
    Item template;
    Map<Integer, Item> data;
    List<ItemConstraint> constraints;
    List<ItemCategory> categories;
}
