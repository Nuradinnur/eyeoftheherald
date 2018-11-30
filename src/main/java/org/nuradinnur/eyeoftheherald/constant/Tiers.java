package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

public enum Tiers {
    IRON("Iron"),
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum"),
    DIAMOND("Diamond"),
    MASTER("Master"),
    GRANDMASTER("Grandmaster"),
    CHALLENGER("Challenger");

    @Getter
    private String formattedName;

    Tiers(String formattedName) {
        this.formattedName = formattedName;
    }
}
