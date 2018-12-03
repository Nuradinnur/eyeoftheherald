package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class MatchTimeline {
    @Id
    private Long gameId;
    private Long timelineInterval;
    private List<MatchFrame> frames;
}
