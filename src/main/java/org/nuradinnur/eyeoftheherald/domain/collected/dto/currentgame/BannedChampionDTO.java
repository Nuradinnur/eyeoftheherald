package org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame;

import lombok.Data;

@Data
public class BannedChampionDTO {
    private Integer pickTurn;
    private Long championId;
    private Long teamId;
}
