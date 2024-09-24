package com.scholarium.profiles.model;


import com.scholarium.profiles.dto.student.CreateStudentDTO;
import com.scholarium.profiles.enums.DiscountEnum;
import com.scholarium.profiles.enums.RoleTypeEnum;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Student extends GenericUser{

    private boolean isRegular;

    private BigDecimal billing;

    private DiscountEnum discount;


    public Student(CreateStudentDTO dto) {
        this.uuid = UUID.randomUUID().toString();
        this.name = dto.name();
        this.login= dto.login();
        this.password = dto.password();
        this.createDate = LocalDateTime.now();
        this.deleted=false;
        this.cpf = dto.cpf();
        this.address= dto.address();
        this.role = RoleTypeEnum.valueOf(dto.roleName());
        this.setBilling(dto.billing());
        this.setRegular(true);
        this.setDiscount(dto.dicount());
    }
}
