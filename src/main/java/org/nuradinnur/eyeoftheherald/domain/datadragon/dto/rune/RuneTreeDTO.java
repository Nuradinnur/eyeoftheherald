package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune;

import lombok.Data;

import java.util.List;

@Data
public class RuneTreeDTO {
    private Integer id;
    private String key;
    private String icon;
    private String name;
    private List<RunePathTierDTO> slots;
}
