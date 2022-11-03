package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;

    @ManyToMany         // relacja wiele do wielu
    @JoinTable          // tworzy tabelkę asocjacyjną
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.registrationDateTime = LocalDateTime.now();
    }
}
