package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

public enum Lanes {
    TOP_LANE("Top"),
    JUNGLE("Jungle"),
    MIDDLE_LANE("Middle"),
    BOT_LANE("Bottom");

    @Getter
    private String formattedName;

    Lanes(String formattedName) {
        this.formattedName = formattedName;
    }
}
