package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.SpellVarsDTO;

import java.util.List;

@Data
public class ChampionSpellDTO {
    private String id;
    private String name;
    private String description;
    private String tooltip;
    private LevelTipsDTO leveltip;
    private Integer maxrank;
    private List<Double> cooldown;
    private String cooldownBurn;
    private List<Integer> cost;
    private String costBurn;
    // TODO: ??
    private Object datavalues;
    private List<List<Double>> effect;
    private List<String> effectBurn;
    private List<SpellVarsDTO> vars;
    private String costType;
    private Integer maxammo;
    private List<Double> range;
    private String rangeBurn;
    private GameSpriteDTO image;
    private String resource;
}
