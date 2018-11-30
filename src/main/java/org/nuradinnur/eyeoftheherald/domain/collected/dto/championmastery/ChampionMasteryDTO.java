package org.nuradinnur.eyeoftheherald.domain.collected.dto.championmastery;

import lombok.Data;

@Data
public class ChampionMasteryDTO {
    private Long playerId;
    private Long championId;
    private Long lastPlayTime;
    private Integer championLevel;
    private Integer championPoints;
    private Long championPointsSinceLastLevel;
    private Long championPointsUntilNextLevel;
    private Boolean chestGranted;
    private Integer tokensEarned;
}
