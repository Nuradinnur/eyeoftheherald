package org.nuradinnur.eyeoftheherald.domain.collected.dto.championmastery;

import lombok.Data;

@Data
public class ChampionMasteryDTO {
    private Boolean chestGranted;
    private Integer championLevel;
    private Integer championPoints;
    private Long championId;
    private Long championPointsSinceLastLevel;
    private Long lastPlayTime;
    private Integer tokensEarned;
    private Long championPointsUntilNextLevel;
    private String summonerId;
}
