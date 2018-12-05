package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class MatchFrameId implements Serializable {
    private Long gameId;
    private Long timestamp;
}
