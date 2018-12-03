package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Lanes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Map;

@Data
@Entity
@IdClass(ParticipantTimelineId.class)
class ParticipantTimeline {
    @Id
    private Long gameId;
    @Id
    private Integer participantId;
    private Lanes lane;
    private Map<String, Double> csDiffPerMinDeltas;
    private Map<String, Double> goldPerMinDeltas;
    private Map<String, Double> xpDiffPerMinDeltas;
    private Map<String, Double> creepsPerMinDeltas;
    private Map<String, Double> xpPerMinDeltas;
    private String role;
    private Map<String, Double> damageTakenDiffPerMinDeltas;
    private Map<String, Double> damageTakenPerMinDeltas;
}
