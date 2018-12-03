package org.nuradinnur.eyeoftheherald.domain.collected.dto.matchlist;

import lombok.Data;

import java.util.List;

@Data
public class MatchListDTO {
    private List<MatchReferenceDTO> matches;
    private Integer totalGames;
    private Integer startIndex;
    private Integer endIndex;
}
