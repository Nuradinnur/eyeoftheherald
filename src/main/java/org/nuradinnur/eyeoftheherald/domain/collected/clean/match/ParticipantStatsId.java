package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class ParticipantStatsId implements Serializable {
    private Long gameId;
    private Integer participantId;
}
