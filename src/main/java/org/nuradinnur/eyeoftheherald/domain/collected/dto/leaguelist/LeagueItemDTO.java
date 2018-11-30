package org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist;

import lombok.Data;

@Data
public class LeagueItemDTO {
    private String playerOrTeamId;
    private String playerOrTeamName;
    private String rank;
    private Boolean hotStreak;
    private MiniSeriesDTO miniSeries;
    private Integer wins;
    private Boolean veteran;
    private Integer losses;
    private Boolean freshBlood;
    private Boolean inactive;
    private Integer leaguePoints;
}
