package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class TeamStatsId implements Serializable {
    private Long gameId;
    private Boolean isBlueTeam;
}
