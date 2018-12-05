package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchlist;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class MatchReferenceId implements Serializable {
    private Long gameId;
    private Integer championId;
}
