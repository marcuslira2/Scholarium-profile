package com.scholarium.profiles.enums;

public enum DiscountEnum {

    NO_DISCOUNT(0),
    BASIC_DISCOUNT(5),
    COOPER_DISCOUNT(10),
    SILVER_DISCOUNT(15),
    GOLD_DISCOUNT(20),
    FULL_DISCOUNT(100);



    final Integer percent;

    DiscountEnum(Integer percent) {
        this.percent = percent;
    }
}
