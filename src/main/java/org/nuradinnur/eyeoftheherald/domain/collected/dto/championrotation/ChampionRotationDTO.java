package org.nuradinnur.eyeoftheherald.domain.collected.dto.championrotation;

import lombok.Data;

import java.util.List;

@Data
public class ChampionRotationDTO {
    private List<Integer> freeChampionIdsForNewPlayers;
    private List<Integer> freeChampionIds;
    private Integer maxNewPlayerLevel;
}
