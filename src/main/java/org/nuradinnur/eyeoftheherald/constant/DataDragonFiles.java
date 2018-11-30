package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

@Getter
public enum DataDragonFiles {
    // TODO: Refactoring.  Not really a good candidate for enum.
    CHAMPIONS("championFull.json"),
    ITEMS("item.json"),
    SUMMONER_ICONS("profileicon.json"),
    RUNES("runesReforged.json"),
    SUMMONER_SPELLS("summoner.json");

    private String fileName;

    DataDragonFiles(String fileName) {
        this.fileName = fileName;
    }
}
