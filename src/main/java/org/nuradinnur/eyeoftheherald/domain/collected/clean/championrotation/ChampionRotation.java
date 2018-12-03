package org.nuradinnur.eyeoftheherald.domain.collected.clean.championrotation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ChampionRotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRetrieved;
    private List<Integer> freeChampionIdsForNewPlayers;
    private List<Integer> freeChampionIds;
    private Integer maxNewPlayerLevel;
}
