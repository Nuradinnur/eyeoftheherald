package org.nuradinnur.eyeoftheherald.domain.collected.clean.championrotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
public class ChampionRotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private ZonedDateTime dateRetrieved;
    private Integer maxNewPlayerLevel;
    @ElementCollection
    private List<Integer> freeChampionIdsForNewPlayers;
    @ElementCollection
    private List<Integer> freeChampionIds;
}
