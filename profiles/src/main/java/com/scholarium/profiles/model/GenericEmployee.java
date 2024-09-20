package com.scholarium.profiles.model;


import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class GenericEmployee extends GenericUser{

    LocalDateTime payday;

    BigDecimal salary;
}
