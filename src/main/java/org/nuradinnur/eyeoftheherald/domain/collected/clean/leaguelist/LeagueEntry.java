package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Divisions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class LeagueEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Long summonerId;
    private String summonerName;
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
