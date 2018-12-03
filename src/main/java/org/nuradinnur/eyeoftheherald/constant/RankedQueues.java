package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

public enum RankedQueues {
    RANKED_SOLO_5x5("RANKED_SOLO_5x5"),
    RANKED_FLEX_SR("RANKED_FLEX_SR"),
    RANKED_FLEX_TT("RANKED_FLEX_TT");

    @Getter
    private String name;

    RankedQueues(String name) {
        this.name = name;
    }
}
