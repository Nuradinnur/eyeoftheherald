package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class MatchTimeline {
    @Id
    private Long gameId;
    private Long timelineInterval;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MatchFrame> frames;
}
