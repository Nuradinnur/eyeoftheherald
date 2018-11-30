package org.nuradinnur.eyeoftheherald.domain.collected.dto.matchlist;

import lombok.Data;

@Data
public class MatchReferenceDTO {
    private Long gameId;
    private Long id;
    private String lane;
    private Integer champion;
    private String platformId;
    private Integer season;
    private Integer queue;
    private String role;
    private Long timestamp;
}
