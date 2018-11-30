package org.nuradinnur.eyeoftheherald.domain.collected.dto.matchtimeline;

import lombok.Data;

import java.util.List;

@Data
public class MatchTimelineDTO {
    private List<MatchFrameDTO> frames;
    private Long frameInterval;
}
