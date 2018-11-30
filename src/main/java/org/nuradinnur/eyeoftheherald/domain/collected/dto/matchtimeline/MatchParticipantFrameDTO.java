package org.nuradinnur.eyeoftheherald.domain.collected.dto.matchtimeline;

import lombok.Data;

@Data
class MatchParticipantFrameDTO {
    private Integer totalGold;
    private Integer teamScore;
    private Integer participantId;
    private Integer level;
    private Integer currentGold;
    private Integer minionsKilled;
    private Integer dominionScore;
    private Integer xp;
    private Integer jungleMinionsKilled;
    private MatchPositionDTO position;
}
