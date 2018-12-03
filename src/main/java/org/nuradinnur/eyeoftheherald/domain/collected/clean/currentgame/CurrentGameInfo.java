package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class CurrentGameInfo {
    @Id
    private Long gameId;
    private Regions region;
    private Matchmaking matchmaking;
    private Modes mode;
    private Maps map;
    private Queues queue;
    private LocalDateTime gameStartTime;
    private Duration gameLength;
    private String observerEncryptionKey;
    private List<CurrentGameParticipant> participants;
    private List<BannedChampion> bannedChampions;
}
