package org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist;

import lombok.Data;

@Data
class MiniSeriesDTO {
    private Integer wins;
    private Integer losses;
    private Integer target;
    private String progress;
}
