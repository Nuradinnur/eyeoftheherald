package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;

public enum Locales {
    CZECH("cs_CZ"),
    GERMANY("de_DE"),
    GREECE("el_GR"),
    AUSTRALIA("en_AU"),
    UNITED_KINGDOM("en_GB"),
    PHILIPPINES("en_PH"),
    SINGAPORE("en_SG"),
    UNITED_STATES("en_US"),
    ARGENTINA("es_AR"),
    SPAIN("es_ES"),
    MEXICO("es_MX"),
    FRANCE("fr_FR"),
    HUNGARY("hu_HU"),
    INDONESIA("id_ID"),
    ITALY("it_IT"),
    JAPAN("ja_JP"),
    KOREA("ko_KR"),
    POLAND("pl_PL"),
    BRAZIL("pt_BR"),
    ROMANIA("ro_RO"),
    RUSSIA("ru_RU"),
    THAILAND("th_TH"),
    TURKEY("tr_TR"),
    VIETNAM("vn_VN"),
    CHINA("zh_CN"),
    MALAYSIA("zh_MY"),
    TAIWAN("zh_TW");

    @Getter
    private String identifier;

    Locales(String identifier) {
        this.identifier = identifier;
    }
}
