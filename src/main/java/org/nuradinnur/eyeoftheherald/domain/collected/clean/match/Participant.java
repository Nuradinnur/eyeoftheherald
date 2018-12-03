package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Tiers;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.List;

@Data
@Entity
@IdClass(ParticipantId.class)
public class Participant {
    @Id
    private Long gameId;
    @Id
    private Integer participantId;
    private Boolean isOnBlueSide;
    private Tiers highestTierThisSeason;
    private Integer championId;
    private List<Integer> summonerSpells;
    private ParticipantStats stats;
    private ParticipantTimeline timeline;
}
