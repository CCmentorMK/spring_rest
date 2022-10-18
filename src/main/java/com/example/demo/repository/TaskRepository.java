package com.example.demo.repository;

import com.example.demo.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface TaskRepository {
    List<Task> TASK_IN_MEMORY = new ArrayList<>(
            Arrays.asList(
                    new Task(1, "X", LocalDateTime.of(
                            2023, 1, 1, 10, 10)),
                    new Task(2, "Y", LocalDateTime.now())
            )
    );
}
