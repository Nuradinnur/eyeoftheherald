package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(TeamBansId.class)
class TeamBansDTO {
    @Id
    private Long gameId;
    @Id
    private Integer pickTurn;
    private Integer championId;
}
