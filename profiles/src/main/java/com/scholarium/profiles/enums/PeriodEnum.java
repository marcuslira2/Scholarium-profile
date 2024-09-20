package com.scholarium.profiles.enums;

public enum PeriodEnum {

    DAY("Manhã"),
    AFTERNOON("Tarde"),
    NIGHT("Noite");


    String name;

    PeriodEnum(String name) {
        this.name = name;
    }
}
