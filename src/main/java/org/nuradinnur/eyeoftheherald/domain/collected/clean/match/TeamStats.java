package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@IdClass(TeamStatsId.class)
public
class TeamStats {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Boolean isBlueTeam;
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<TeamBans> bans;
}
