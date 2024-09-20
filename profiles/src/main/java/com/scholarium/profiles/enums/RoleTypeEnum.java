package com.scholarium.profiles.enums;

public enum RoleTypeEnum {

    PROFESSOR("Professor"),
    STUDENT("Estudante");

    private final String name;

    RoleTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
