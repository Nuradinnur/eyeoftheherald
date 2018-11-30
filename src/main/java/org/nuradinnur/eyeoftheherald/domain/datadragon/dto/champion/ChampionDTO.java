package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.GameSpriteDTO;

import java.util.List;

@Data
public class ChampionDTO {
    private String id;
    private Integer key;
    private String name;
    private String title;
    private String blurb;
    private String lore;
    private List<String> allytips;
    private List<String> enemytips;
    private ChampionInfoDTO info;
    private GameSpriteDTO image;
    private List<String> tags;
    private String partype;
    private ChampionStatsDTO stats;
    private List<ChampionSkinDTO> skins;
    private List<ChampionSpellDTO> spells;
    private ChampionPassiveDTO passive;
    private List<ChampionRecommendationDTO> recommended;
}
