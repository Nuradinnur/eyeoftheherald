package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.RankedQueues;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(PromotionalSeriesId.class)
class PromotionalSeries {
    @Id
    private Long summonerId;
    @Id
    private RankedQueues rankedQueue;
    private Integer wins;
    private Integer losses;
    private Integer target;
    private String progress;
}
