package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

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

    @Getter private int mapId;
    @Getter private String formattedName;

    Maps(int mapId, String formattedName) {
        this.mapId = mapId;
        this.formattedName = formattedName;
    }
}
