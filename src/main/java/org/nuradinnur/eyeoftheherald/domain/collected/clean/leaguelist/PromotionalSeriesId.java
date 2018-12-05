package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.EqualsAndHashCode;
import org.nuradinnur.eyeoftheherald.constant.RankedQueues;

import java.io.Serializable;

@EqualsAndHashCode
class PromotionalSeriesId implements Serializable {
    private Long summonerId;
    private RankedQueues rankedQueue;
}
