package org.nuradinnur.eyeoftheherald.domain.collected.dto.matchtimeline;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
class MatchFrameDTO {
    private Long timestamp;
    private Map<String, MatchParticipantFrameDTO> participantFrames;
    private List<MatchEventDTO> events;
}
