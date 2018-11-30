package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell;

import lombok.Value;

import java.util.Map;

@Value
public class SummonerSpells {
    Map<Integer, SummonerSpell> data;
}
