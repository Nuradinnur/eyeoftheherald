package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchlist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Data
@Entity
@IdClass(MatchReferenceId.class)
public class MatchReference {
    @Id
    private Long gameId;
    @Id
    private Integer championId;
    private LocalDateTime timestamp;
    @Enumerated
    private Seasons season;
    @Enumerated
    private Regions region;
    @Enumerated
    private Queues queue;
    @Enumerated
    private Lanes lane;
    @Enumerated
    private Roles role;
}
