package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
@IdClass(MatchFrameId.class)
class MatchFrame {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Long timestamp;
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, MatchParticipantFrame> participantFrames;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MatchEvent> events;
}
