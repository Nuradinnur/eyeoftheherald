package org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist;

import lombok.Data;

@Data
public class LeaguePositionDTO {
    private String queueType;
    private Boolean hotStreak;
    private Integer wins;
    private Boolean veteran;
    private Integer losses;
    private String playerOrTeamId;
    private String leagueName;
    private String playerOrTeamName;
    private Boolean inactive;
    private String rank;
    private Boolean freshBlood;
    private String leagueId;
    private String tier;
    private Integer leaguePoints;
}