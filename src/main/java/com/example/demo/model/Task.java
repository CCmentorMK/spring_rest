package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data               // dodaje metody get/set oraz toString opcjonalnie @Getter lub @Setter lub @ToString
@NoArgsConstructor  // dodaje domyślny konstruktor
@AllArgsConstructor // dodaje konstuktor z wszystkimi polami w argumencie
public class Task {
    private int taskId;                     // nie róbcie samego id
    private String taskName;
    private LocalDateTime taskDeadline;
}
