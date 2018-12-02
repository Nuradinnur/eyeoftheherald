package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion;

import lombok.Data;

import java.util.List;

@Data
public class ChampionRecommendationDTO {
    private String champion;
    private String title;
    private String map;
    private String mode;
    private String type;
    private String customTag;
    private Integer sortrank;
    private Boolean extensionPage;
    // TODO: ??
    private Object customPanel;
    private List<ChampionRecommendationBlockDTO> blocks;
}
