package org.nuradinnur.eyeoftheherald.constant;

import java.util.HashMap;
import java.util.Map;

public enum Modes {
    SUMMONERS_RIFT("CLASSIC"),
    DOMINION("ODIN"),
    ALL_RANDOM_ALL_MID("ARAM"),
    TUTORIAL("TUTORIAL"),
    ULTRA_RAPID_FIRE("URF"),
    DOOM_BOTS("DOOMBOTSTEEMO"),
    ONE_FOR_ALL("ONEFORALL"),
    ASCENSION("ASCENSION"),
    SNOWDOWN_SHOWDOWN("FIRSTBLOOD"),
    LEGEND_OF_THE_PORO_KING("KINGPORO"),
    NEXUS_SIEGE("SIEGE"),
    BLOOD_MOON("ASSASSINATE"),
    ALL_RANDOM_ALL_SUMMONERS_RIFT("ARSR"),
    DARK_STAR_SINGULARITY("DARKSTAR"),
    STAR_GUARDIAN_INVASION("STARGUARDIAN"),
    PROJECT_HUNTERS("PROJECT"),
    NEXUS_BLITZ("GAMEMODEX"),
    ODYSSEY_EXTRACTION("ODYSSEY");

    private static final Map<String, Modes> lookup = new HashMap<>();
    private String key;

    static {
        for (Modes mode : Modes.values()) {
            lookup.put(mode.key, mode);
        }
    }

    Modes(String key) {
        this.key = key;
    }

    public static Modes getByValue(String value) {
        return lookup.get(value);
    }
}
