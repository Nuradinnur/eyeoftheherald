package org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame;

import lombok.Data;

import java.util.List;

@Data
public class PerksDTO {
    private Long perkStyle;
    private List<Long> perkIds;
    private Long perkSubStyle;
}
