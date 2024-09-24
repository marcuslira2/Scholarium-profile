package com.scholarium.profiles.dto.student;

import com.scholarium.profiles.enums.DiscountEnum;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateStudentDTO(
        @NotBlank String name,
        @NotBlank String login,
        @NotBlank String password,
        @NotBlank String cpf,
        @NotBlank String address,
        @NotBlank String roleName,
        @NotBlank BigDecimal billing,
        @NotBlank DiscountEnum dicount
        ) {
}
