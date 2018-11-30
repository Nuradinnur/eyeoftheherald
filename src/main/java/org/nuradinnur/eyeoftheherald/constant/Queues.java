package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

public enum Queues {
    RANKED_SOLO_5x5("RANKED_SOLO_5x5"),
    RANKED_FLEX_SR("RANKED_FLEX_SR"),
    RANKED_FLEX_TT("RANKED_FLEX_TT");

    @Getter
    private String name;

    Queues(String name) {
        this.name = name;
    }
}
