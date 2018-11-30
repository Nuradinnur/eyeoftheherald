package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune;

import lombok.Data;

import java.util.List;

@Data
public class RunePathDTO {
    private Integer id;
    private String key;
    private String icon;
    private String name;
    private List<RunePathTierDTO> slots;
}
