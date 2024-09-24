package com.scholarium.profiles.model;


import com.scholarium.profiles.dto.professor.CreateProfessorDTO;
import com.scholarium.profiles.enums.RoleTypeEnum;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
public class Professor extends GenericEmployee{

    public Professor(CreateProfessorDTO dto){
        this.uuid = UUID.randomUUID().toString();
        this.name = dto.name();
        this.login= dto.login();
        this.password = dto.password();
        this.createDate = LocalDateTime.now();
        this.deleted=false;
        this.cpf = dto.cpf();
        this.address= dto.address();
        this.role = RoleTypeEnum.valueOf(dto.roleName());
    }


}
