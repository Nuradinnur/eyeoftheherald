package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class TeamBansId implements Serializable {
    private Long gameId;
    private Integer pickTurn;
}
