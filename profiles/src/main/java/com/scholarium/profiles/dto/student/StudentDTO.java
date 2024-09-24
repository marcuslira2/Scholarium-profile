package com.scholarium.profiles.dto.student;

public record StudentDTO(
        String name,
        String cpf,
        boolean isRegular
) {
}
