package org.nuradinnur.eyeoftheherald.domain.collected.clean.championmastery;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Data
@Entity
@IdClass(ChampionMasteryId.class)
public class ChampionMastery {
    @Id
    private Long summonerId;
    @Id
    private Integer championId;
    private Integer championLevel;
    private LocalDateTime lastPlayTime;
    private Integer championPoints;
    private Long championPointsSinceLastLevel;
    private Long championPointsUntilNextLevel;
    private Boolean chestGranted;
    private Integer tokensEarned;
}
