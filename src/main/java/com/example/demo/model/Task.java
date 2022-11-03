package com.example.demo.model;

import com.example.demo.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data               // dodaje metody get/set oraz toString opcjonalnie @Getter lub @Setter lub @ToString
@NoArgsConstructor  // dodaje domyślny konstruktor
@AllArgsConstructor // dodaje konstuktor z wszystkimi polami w argumencie
@Entity
@Table(name = "tasks") // automatycznie nazwane będzie task
public class Task {
    @Id                                     // klucz główny
    @GeneratedValue                         // autoinkrementacja
    private int taskId;                     // nie róbcie samego id
    private String taskName;                // mapowany -> varchar(255)
    private LocalDateTime taskDeadline;     // mapowany -> date & time
    @Enumerated
    private Category category;

    @ManyToOne                              // relacja wiele do jednego
    @JoinColumn                             // dodaje nową kolumnę z kluczem obcym
    private User user;

    public Task(String taskName) {
        this.taskName = taskName;
        this.taskDeadline = LocalDateTime.now();
        this.category = Category.NEW;
    }
}
