package com.example.demo.repository;

import com.example.demo.model.Task;
import com.example.demo.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository                             // JpaRepository<ModelClass, PK Type>
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findTaskByTaskName(String taskName);
    List<Task> findAllByCategory(Category category);
    List<Task> findAllByCategoryAndTaskDeadlineLessThan(Category category, LocalDateTime deadline);
}
