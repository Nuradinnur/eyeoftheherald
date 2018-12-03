package org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame;

import lombok.Data;

import java.util.List;

@Data
public class CurrentGameInfoDTO {
    private Long gameId;
    private Long gameStartTime;
    private String platformId;
    private String gameMode;
    private Long mapId;
    private String gameType;
    private List<BannedChampionDTO> bannedChampions;
    private ObserverDTO observers;
    private List<CurrentGameParticipantDTO> participants;
    private Long gameLength;
    private Long gameQueueConfigId;
}
