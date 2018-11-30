package org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist;

import lombok.Data;

import java.util.List;

@Data
public class LeagueListDTO {
    private String leagueId;
    private String tier;
    private List<LeagueItemDTO> entries;
    private String queue;
    private String name;
}
