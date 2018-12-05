package org.nuradinnur.eyeoftheherald.domain.collected.clean.championmastery;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public
class ChampionMasteryId implements Serializable {
    private Long summonerId;
    private Integer championId;
}
