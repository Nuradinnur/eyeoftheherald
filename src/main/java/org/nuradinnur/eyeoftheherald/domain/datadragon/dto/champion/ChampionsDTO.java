package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;

import java.util.Map;

@Data
public class ChampionsDTO {
    private String type;
    private String format;
    private String version;
    private Map<String, ChampionDTO> data;
    private Map<Integer, String> keys;
}
