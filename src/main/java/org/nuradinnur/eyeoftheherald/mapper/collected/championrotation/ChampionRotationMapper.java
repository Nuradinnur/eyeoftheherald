package org.nuradinnur.eyeoftheherald.mapper.collected.championrotation;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.championrotation.ChampionRotation;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.championrotation.ChampionRotationDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;

@Component
public class ChampionRotationMapper {

    ChampionRotation map(ChampionRotationDTO dto) {
        val result = new ChampionRotation();
        result.setDateRetrieved(Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.UTC));
        result.setMaxNewPlayerLevel(dto.getMaxNewPlayerLevel());
        result.setFreeChampionIdsForNewPlayers(dto.getFreeChampionIdsForNewPlayers());
        result.setFreeChampionIds(dto.getFreeChampionIds());
        return result;
    }
}
