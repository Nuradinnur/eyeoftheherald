package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Divisions;
import org.nuradinnur.eyeoftheherald.constant.RankedQueues;

import javax.persistence.*;

@Data
@Entity
@IdClass(LeaguePositionId.class)
public class LeaguePosition {
    @Id
    private Long summonerId;
    @Id
    private RankedQueues rankedQueue;
    private String summonerName;
    private String leagueName;
    private String leagueId;
    @Enumerated
    private Divisions division;
    private Integer wins;
    private Integer losses;
    private Integer leaguePoints;
    private Boolean isOnWinningSpree;
    private Boolean isFreshBlood;
    private Boolean isVeteran;
    private Boolean isDecaying;
    @OneToOne(cascade = CascadeType.ALL)
    private PromotionalSeries promotionalSeries;
}
