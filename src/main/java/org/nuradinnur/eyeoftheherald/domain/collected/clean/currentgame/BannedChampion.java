package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(BannedChampionId.class)
public class BannedChampion {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Integer pickTurn;
    private Integer championId;
    private Boolean isOnBlueSide;
}