package com.scholarium.profiles.model;


import com.scholarium.profiles.enums.DiscountEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Student extends GenericUser{

    boolean isRegular;

    BigDecimal billing;

    DiscountEnum discount;

}
