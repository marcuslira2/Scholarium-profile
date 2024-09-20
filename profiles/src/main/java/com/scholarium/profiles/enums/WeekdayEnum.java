package com.scholarium.profiles.enums;

public enum WeekdayEnum {
    MONDAY("Segunda-Feira"),
    TUESDAY("Terca-Feira"),
    WEDNESDAY("Quarta-Feira"),
    THURSDAY("Quinta-Feira"),
    FRIDAY("Sexta-Feira"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    final String name;

    WeekdayEnum(String name) {
        this.name = name;
    }
}
