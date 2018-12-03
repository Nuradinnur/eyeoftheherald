package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Match {
    @Id
    private Long gameId;
    private Seasons season;
    private String patch;
    private Regions region;
    private Matchmaking matchmaking;
    private Queues queue;
    private Modes mode;
    private Maps map;
    private LocalDateTime startTime;
    private Duration duration;
    private List<ParticipantIdentity> participantIdentities;
    private List<Participant> participants;
    private List<TeamStats> teams;
}
