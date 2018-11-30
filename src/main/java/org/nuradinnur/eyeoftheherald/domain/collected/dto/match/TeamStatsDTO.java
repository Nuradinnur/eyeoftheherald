package org.nuradinnur.eyeoftheherald.domain.collected.dto.match;

import lombok.Data;

import java.util.List;

@Data
class TeamStatsDTO {
    private Long id;
    private Boolean firstDragon;
    private Boolean firstInhibitor;
    private List<TeamBansDTO> bans;
    private Integer baronKills;
    private Boolean firstRiftHerald;
    private Boolean firstBaron;
    private Integer riftHeraldKills;
    private Boolean firstBlood;
    private Integer teamId;
    private Boolean firstTower;
    private Integer vilemawKills;
    private Integer inhibitorKills;
    private Integer towerKills;
    private Integer dominionVictoryScore;
    private String win;
    private Integer dragonKills;
}
