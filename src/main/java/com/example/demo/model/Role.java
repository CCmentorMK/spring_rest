package com.example.demo.model;

import com.example.demo.model.enums.RoleName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private int roleId;
    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;
}
