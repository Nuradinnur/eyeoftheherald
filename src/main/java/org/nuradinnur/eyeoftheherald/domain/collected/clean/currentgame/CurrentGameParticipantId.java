package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class CurrentGameParticipantId implements Serializable {
    private Long gameId;
    private Long summonerId;
}
