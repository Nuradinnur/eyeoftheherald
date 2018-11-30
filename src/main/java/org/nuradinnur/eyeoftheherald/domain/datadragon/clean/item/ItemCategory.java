package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item;

import lombok.Value;

import java.util.List;

@Value
public class ItemCategory {
    String category;
    List<String> subCategories;
}
