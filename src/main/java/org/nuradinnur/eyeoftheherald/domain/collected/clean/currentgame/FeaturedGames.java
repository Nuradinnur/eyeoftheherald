package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class FeaturedGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRetrieved;
    private Long refreshInterval;
    private List<CurrentGameInfo> gameList;
}
