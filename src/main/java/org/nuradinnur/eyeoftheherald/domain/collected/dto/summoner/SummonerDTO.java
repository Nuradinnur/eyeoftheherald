package org.nuradinnur.eyeoftheherald.domain.collected.dto.summoner;

import lombok.Data;

@Data
public class SummonerDTO {
    private Long id;
    private Integer profileIconId;
    private String name;
    private Long summonerLevel;
    private Long revisionDate;
    private Long accountId;
}
