package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.List;

@Data
@Entity
@IdClass(TeamStatsId.class)
class TeamStats {
    @Id
    private Long gameId;
    @Id
    private Boolean isOnBlueSide;
    private Boolean isWin;
    private Boolean firstBlood;
    private Boolean firstTower;
    private Boolean firstInhibitor;
    private Boolean firstDragon;
    private Boolean firstRiftHerald;
    private Boolean firstBaron;
    private Integer towerKills;
    private Integer inhibitorKills;
    private Integer dragonKills;
    private Integer riftHeraldKills;
    private Integer baronKills;
    private Integer vilemawKills;
    private Integer dominionVictoryScore;
    private List<TeamBansDTO> bans;
}
