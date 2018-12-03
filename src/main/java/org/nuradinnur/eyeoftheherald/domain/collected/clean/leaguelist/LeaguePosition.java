package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Divisions;
import org.nuradinnur.eyeoftheherald.constant.RankedQueues;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(LeaguePositionId.class)
public class LeaguePosition {
    @Id
    private Long summonerId;
    private String summonerName;
    @Id
    private RankedQueues rankedQueue;
    private String leagueName;
    private String leagueId;
    private Divisions division;
    private Integer wins;
    private Integer losses;
    private Integer leaguePoints;
    private Boolean isOnWinningSpree;
    private Boolean isFreshBlood;
    private Boolean isVeteran;
    private Boolean isDecaying;
    private PromotionalSeries promotionalSeries;
}
