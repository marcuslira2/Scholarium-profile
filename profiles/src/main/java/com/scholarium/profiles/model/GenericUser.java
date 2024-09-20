package com.scholarium.profiles.model;


import com.scholarium.profiles.enums.RoleTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class GenericUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String uuid;
    String name;
    String login;
    String password;
    LocalDateTime createDate;
    LocalDateTime deletedDate;
    boolean deleted;
    String cpf;
    String address;
    String photo;
    RoleTypeEnum role;

}
