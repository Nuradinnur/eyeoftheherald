package org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame;

import lombok.Data;

import java.util.List;

@Data
public class FeaturedGamesDTO {
    private Long clientRefreshInterval;
    private List<CurrentGameDTO> gameList;
}
