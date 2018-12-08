package org.nuradinnur.eyeoftheherald.mapper.collected.currentgame;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame.FeaturedGames;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.FeaturedGamesDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@Component
public class FeaturedGamesMapper {

    private final CurrentGameMapper currentGameMapper;

    public FeaturedGamesMapper(CurrentGameMapper currentGameMapper) {
        this.currentGameMapper = currentGameMapper;
    }

    FeaturedGames map(FeaturedGamesDTO dto) {
        val result = new FeaturedGames();
        result.setDateRetrieved(Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.UTC));
        result.setRefreshInterval(dto.getClientRefreshInterval());
        val currentGames = dto.getGameList().stream()
                .map(currentGameMapper::map)
                .collect(Collectors.toList());
        result.setGames(currentGames);
        return result;
    }
}
