package org.nuradinnur.eyeoftheherald.constant;


import lombok.Getter;

public enum Roles {
    SOLO(10),
    DUO(20),
    DUO_CARRY(30),
    DUO_SUPPORT(40),
    NONE(50);

    @Getter
    private int roleId;

    Roles(int roleId) {
    }
}
