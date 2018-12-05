package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class CompletedMatch {
    @Id
    private Long gameId;
    @Enumerated
    private Seasons season;
    private String patch;
    @Enumerated
    private Regions region;
    @Enumerated
    private Matchmaking matchmaking;
    @Enumerated
    private Queues queue;
    @Enumerated
    private Modes mode;
    @Enumerated
    private Maps map;
    private LocalDateTime startTime;
    private Long duration;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ParticipantIdentity> participantIdentities;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participants;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TeamStats> teams;
}
