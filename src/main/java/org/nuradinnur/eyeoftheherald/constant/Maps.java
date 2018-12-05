package org.nuradinnur.eyeoftheherald.constant;

import java.util.HashMap;
import java.util.Map;

public enum Maps {
    UNKNOWN(0, "Unknown"),
    SUMMONERS_RIFT_OLD_SUMMER(1, "Classic Summoner's Rift"),
    SUMMONERS_RIFT_OLD_AUTUMN(2, "Classic Summoner's Rift (autumn)"),
    THE_PROVING_GROUNDS(3, "Proving Grounds"),
    TWISTED_TREELINE_OLD(4, "Classic Twisted Treeline"),
    THE_CRYSTAL_SCAR(8, "Crystal Scar"),
    TWISTED_TREELINE_CURRENT(10, "Twisted Treeline"),
    SUMMONERS_RIFT_CURRENT(11, "Summoner's Rift"),
    HOWLING_ABYSS(12, "Howling Abyss"),
    BUTCHERS_BRIDGE(14, "Butcher's Bridge"),
    COSMIC_RUINS(16, "Cosmic Ruins"),
    VALORAN_CITY_PARK(18, "Valoran City Park"),
    SUBSTRUCTURE_43(19, "Substructure 43"),
    CRASH_SITE(20, "Crash Site"),
    NEXUS_BLITZ(21, "Nexus Blitz"),
    ANY(999, "Any map");

    private static final Map<Integer, Maps> lookup = new HashMap<>();
    private int id;
    private String formattedName;

    static {
        for (Maps map : Maps.values()) {
            lookup.put(map.id, map);
        }
    }

    Maps(int id, String formattedName) {
        this.id = id;
        this.formattedName = formattedName;
    }

    public static Maps getByValue(int id) {
        return lookup.get(id);
    }
}
