package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Divisions;
import org.nuradinnur.eyeoftheherald.constant.Tiers;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@IdClass(LeagueEntryId.class)
public class LeagueEntry {
    @Id
    private Long summonerId;
    @Id
    private Tiers tier;
    private LocalDateTime dateRetrieved;
    private String summonerName;
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
