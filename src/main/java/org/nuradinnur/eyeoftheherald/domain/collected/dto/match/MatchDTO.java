package org.nuradinnur.eyeoftheherald.domain.collected.dto.match;

import lombok.Data;

import java.util.List;

@Data
public class MatchDTO {
    private Long gameId;
    private Integer seasonId;
    private Integer queueId;
    private List<ParticipantIdentityDTO> participantIdentities;
    private String gameVersion;
    private String platformId;
    private String gameMode;
    private Integer mapId;
    private String gameType;
    private List<TeamStatsDTO> teams;
    private List<ParticipantDTO> participants;
    private Long gameDuration;
    private Long gameCreation;
}
