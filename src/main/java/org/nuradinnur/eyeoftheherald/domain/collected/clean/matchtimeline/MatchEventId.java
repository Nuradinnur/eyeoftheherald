package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class MatchEventId implements Serializable {
    private Long gameId;
    private Integer participantId;
}
