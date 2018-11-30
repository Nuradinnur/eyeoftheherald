package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;

import java.util.List;

@Data
public
class ChampionRecommendationBlockDTO {
    private String type;
    private Boolean recMath;
    private Boolean recSteps;
    private Integer minSummonerLevel;
    private Integer maxSummonerLevel;
    private String showIfSummonerSpell;
    private String hideIfSummonerSpell;
    private String appendAfterSection;
    private List<String> visibleWithAllOf;
    private List<String> hiddenWithAnyOf;
    private List<ChampionRecommendationBlockItemDTO> items;
}
