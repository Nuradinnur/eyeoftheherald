package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BannedChampion {
    @Id
    private Long gameId;
    @Id
    private Integer pickTurn;
    private Integer championId;
    private Integer teamId;
}
