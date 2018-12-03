package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.List;
import java.util.Map;

@Data
@Entity
@IdClass(MatchFrameId.class)
class MatchFrame {
    @Id
    private Long gameId;
    @Id
    private Long timestamp;
    private Map<String, MatchParticipantFrame> participantFrames;
    private List<MatchEvent> events;
}
