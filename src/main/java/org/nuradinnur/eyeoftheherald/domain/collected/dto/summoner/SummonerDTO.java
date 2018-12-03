package org.nuradinnur.eyeoftheherald.domain.collected.dto.summoner;

import lombok.Data;

@Data
public class SummonerDTO {
    private Integer profileIconId;
    private String name;
    private String puuid;
    private Long summonerLevel;
    private Long revisionDate;
    private Long id;
    private Long accountId;
}
