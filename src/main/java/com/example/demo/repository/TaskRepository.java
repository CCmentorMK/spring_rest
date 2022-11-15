package com.example.demo.repository;

import com.example.demo.model.Task;
import com.example.demo.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository                             // JpaRepository<ModelClass, PK Type>
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findTaskByTaskName(String taskName);
    List<Task> findAllByCategory(Category category);
    List<Task> findAllByCategoryAndTaskDeadlineLessThan(Category category, LocalDateTime deadline);

    @Query("SELECT t.category, count(t.category) FROM Task t GROUP BY t.category")
    List<Object[]> groupTasksByCategory();

    @Query(value = "SELECT t.category, count(t.category) FROM tasks t GROUP BY t.category",
            nativeQuery = true)
    List<Object[]> groupTasksByCategoryNativeSQL();
}
