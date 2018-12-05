package org.nuradinnur.eyeoftheherald.mapper.collected.championmastery;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.championmastery.ChampionMastery;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.championmastery.ChampionMasteryDTO;

import java.time.Instant;
import java.time.ZoneOffset;

public class ChampionMasteryMapper {

    public ChampionMastery map(ChampionMasteryDTO dto) {
        val result = new ChampionMastery();
        result.setSummonerId(Long.parseLong(dto.getSummonerId()));
        result.setChampionId(dto.getChampionId().intValue());
        result.setChampionLevel(dto.getChampionLevel());
        val lastPlayTime = Instant.ofEpochMilli(dto.getLastPlayTime()).atZone(ZoneOffset.UTC);
        result.setLastPlayTime(lastPlayTime);
        result.setChampionPoints(dto.getChampionPoints());
        result.setChampionPointsSinceLastLevel(dto.getChampionPointsSinceLastLevel());
        result.setChampionPointsUntilNextLevel(dto.getChampionPointsUntilNextLevel());
        result.setChestGranted(dto.getChestGranted());
        result.setTokensEarned(dto.getTokensEarned());
        return result;
    }
}
