package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.EqualsAndHashCode;
import org.nuradinnur.eyeoftheherald.constant.Tiers;

import java.io.Serializable;

@EqualsAndHashCode
class LeagueEntryId implements Serializable {
    private Long summonerId;
    private Tiers tier;
}
