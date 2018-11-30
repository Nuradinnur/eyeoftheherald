package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;

import java.util.List;

@Data
public class SummonerSpellDTO {
    private Integer key;
    private String id;
    private String name;
    private String description;
    private String tooltip;
    private Integer maxrank;
    private List<Integer> cooldown;
    private String cooldownBurn;
    private List<Integer> cost;
    private String costBurn;
    // TODO: ??
    private Object datavalues;
    private List<List<Double>> effect;
    private List<String> effectBurn;
    private List<SummonerSpellEffectDTO> vars;
    private Integer summonerLevel;
    private List<String> modes;
    private String costType;
    private Integer maxammo;
    private List<Integer> range;
    private String rangeBurn;
    private GameSpriteDTO image;
    private String resource;
}
