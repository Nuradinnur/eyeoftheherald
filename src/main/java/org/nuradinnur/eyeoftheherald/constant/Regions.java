package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

public enum Regions {
    BR("br1"),
    EUNE("eun1"),
    EUW("euw1"),
    JP("jp1"),
    KR("kr"),
    LAN("la1"),
    LAS("la2"),
    NA("na1"),
    OCE("oc1"),
    TR("tr1"),
    RU("ru"),
    PBE("pbe1");

    @Getter
    private String platform;

    Regions(String platform) {
        this.platform = platform;
    }
}
