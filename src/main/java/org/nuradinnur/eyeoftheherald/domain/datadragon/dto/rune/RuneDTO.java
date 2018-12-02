package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune;

import lombok.Data;

@Data
public class RuneDTO {
    private Integer id;
    private String key;
    private String icon;
    private String name;
    private String shortDesc;
    private String longDesc;
}
