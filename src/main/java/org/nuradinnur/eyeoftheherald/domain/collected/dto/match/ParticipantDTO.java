package org.nuradinnur.eyeoftheherald.domain.collected.dto.match;

import lombok.Data;

@Data
public class ParticipantDTO {
    private ParticipantStatsDTO stats;
    private Integer participantId;
    private ParticipantTimelineDTO timeline;
    private Integer teamId;
    private Integer spell2Id;
    private String highestAchievedSeasonTier;
    private Integer spell1Id;
    private Integer championId;
}
