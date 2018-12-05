package org.nuradinnur.eyeoftheherald.domain.collected.clean.championmastery;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
class ChampionMasteryId implements Serializable {
    private Long summonerId;
    private Integer championId;
}
