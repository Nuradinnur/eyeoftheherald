package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Lanes;
import org.nuradinnur.eyeoftheherald.constant.Roles;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
@IdClass(ParticipantTimelineId.class)
class ParticipantTimeline {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    @JsonIgnore
    private Integer participantId;
    @Enumerated
    private Lanes lane;
    @Enumerated
    private Roles role;
    @ElementCollection
    private List<Double> goldPerMinute;
    @ElementCollection
    private List<Double> creepScorePerMinute;
    @ElementCollection
    private List<Double> creepScoreDifferentials;
    @ElementCollection
    private List<Double> experiencePerMinute;
    @ElementCollection
    private List<Double> experienceDifferentials;
    @ElementCollection
    private List<Double> damageTakenPerMinute;
    @ElementCollection
    private List<Double> damageTakenDifferentials;
}
