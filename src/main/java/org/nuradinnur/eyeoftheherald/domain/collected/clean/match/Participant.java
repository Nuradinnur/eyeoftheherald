package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Tiers;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@IdClass(ParticipantId.class)
public class Participant {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Integer participantId;
    private Boolean isOnBlueSide;
    @Enumerated
    private Tiers highestTierThisSeason;
    private Integer championId;
    @ElementCollection
    private List<Integer> summonerSpellIds;
    @OneToOne(cascade = CascadeType.ALL)
    private ParticipantStats stats;
    @OneToOne(cascade = CascadeType.ALL)
    private ParticipantTimeline timeline;
}
