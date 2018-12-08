package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
public class CurrentGame {
    @Id
    private Long gameId;
    @Enumerated
    private Regions region;
    @Enumerated
    private Matchmaking matchmaking;
    @Enumerated
    private Modes mode;
    @Enumerated
    private Maps map;
    @Enumerated
    private Queues queue;
    private ZonedDateTime gameStartTime;
    private Long gameLength;
    private String observerEncryptionKey;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CurrentGameParticipant> participants;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BannedChampion> bannedChampions;
}
