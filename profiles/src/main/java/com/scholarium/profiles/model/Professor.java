package com.scholarium.profiles.model;


import com.scholarium.profiles.dto.CreateProfessorDTO;
import com.scholarium.profiles.enums.RoleTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
