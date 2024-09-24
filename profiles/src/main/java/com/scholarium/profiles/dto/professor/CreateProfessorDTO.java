package com.scholarium.profiles.dto.professor;

import jakarta.validation.constraints.NotBlank;

public record CreateProfessorDTO(
       @NotBlank String name,
       @NotBlank String login,
       @NotBlank String password,
       @NotBlank String cpf,
       @NotBlank String address,
       @NotBlank String roleName
) {
}
