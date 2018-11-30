package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell;

import lombok.Data;

import java.util.Map;

@Data
public class SummonerSpellsDTO {
    private String type;
    private String version;
    private Map<String, SummonerSpellDTO> data;
}
