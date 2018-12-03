package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class MatchReference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Long gameId;
    private LocalDateTime timestamp;
    private Seasons season;
    private Regions region;
    private Queues queue;
    private Lanes lane;
    private Roles role;
    private Integer championId;
}
