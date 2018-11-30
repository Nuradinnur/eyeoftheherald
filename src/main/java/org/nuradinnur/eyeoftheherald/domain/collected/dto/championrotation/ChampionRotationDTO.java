package org.nuradinnur.eyeoftheherald.domain.collected.dto.championrotation;

import lombok.Data;

import java.util.List;

@Data
public class ChampionRotationDTO {
    private Integer maxNewPlayerLevel;
    private List<Integer> freeChampionIds;
    private List<Integer> freeChampionIdsForNewPlayers;
}
