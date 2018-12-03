package org.nuradinnur.eyeoftheherald.domain.collected.dto.match;

import lombok.Data;

@Data
public class PlayerDTO {
    private Long currentAccountId;
    private String currentPlatformId;
    private String summonerName;
    private String matchHistoryUri;
    private String platformId;
    private Integer profileIcon;
    private Long summonerId;
    private Long accountId;
}
