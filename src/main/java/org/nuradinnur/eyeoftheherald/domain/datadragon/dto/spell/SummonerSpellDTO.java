package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.SpellVarsDTO;

import java.util.List;

@Data
public class SummonerSpellDTO {
    Integer key;
    String id;
    String name;
    String description;
    String tooltip;
    Integer maxrank;
    List<Integer> cooldown;
    String cooldownBurn;
    List<Integer> cost;
    String costBurn;
    // TODO: ??
    Object datavalues;
    List<List<Double>> effect;
    List<String> effectBurn;
    List<SpellVarsDTO> vars;
    Integer summonerLevel;
    List<String> modes;
    String costType;
    Integer maxammo;
    List<Integer> range;
    String rangeBurn;
    GameSpriteDTO image;
    String resource;
}
