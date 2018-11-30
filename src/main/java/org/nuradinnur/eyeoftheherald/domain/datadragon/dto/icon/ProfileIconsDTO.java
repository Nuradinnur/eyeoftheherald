package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon;

import lombok.Data;

import java.util.Map;

@Data
public class ProfileIconsDTO {
    private String type;
    private String version;
    private Map<Integer, ProfileIconDTO> data;
}
