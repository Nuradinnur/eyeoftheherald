package org.nuradinnur.eyeoftheherald.constant;

import java.util.HashMap;
import java.util.Map;

public enum Seasons {
    PRESEASON_3("Preseason 3", 0),
    SEASON_3("Season 3", 1),
    PRESEASON_4("Preseason 4", 2),
    SEASON_4("Season 4", 3),
    PRESEASON_5("Preseason 5", 4),
    SEASON_5("Season 5", 5),
    PRESEASON_6("Preseason 6", 6),
    SEASON_6("Season 6", 7),
    PRESEASON_7("Preseason 7", 8),
    SEASON_7("Season 7", 9),
    PRESEASON_8("Preseason 8", 10),
    SEASON_8("Season 8", 11),
    PRESEASON_9("Preseason 9", 12),
    SEASON_9("Season 9", 13),
    PRESEASON_10("Preseason 10", 14),
    SEASON_10("Season 10", 15);

    private static final Map<Integer, Seasons> lookup = new HashMap<>();
    private String formattedName;
    private int id;

    static {
        for (Seasons season : Seasons.values()) {
            lookup.put(season.id, season);
        }
    }

    Seasons(String formattedName, int id) {
        this.formattedName = formattedName;
        this.id = id;
    }

    public static Seasons getByValue(int value) {
        return lookup.get(value);
    }
}
