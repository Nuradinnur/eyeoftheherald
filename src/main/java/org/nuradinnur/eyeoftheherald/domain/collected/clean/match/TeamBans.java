package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(TeamBansId.class)
class TeamBans {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Integer pickTurn;
    private Integer championId;
}
