package org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame;

import lombok.Data;

import java.util.List;

@Data
class CurrentGameParticipantDTO {
    private Long profileIconId;
    private Long championId;
    private String summonerName;
    private List<GameCustomizationObjectDTO> gameCustomizationObjects;
    private Boolean bot;
    private PerksDTO perks;
    private Long spell2Id;
    private Long teamId;
    private Long spell1Id;
    private Long summonerId;
}
