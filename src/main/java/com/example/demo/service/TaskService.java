package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(String taskName, Optional<User> user);
    List<Task> getTasks();
    Optional<Task> getTaskById(int taskId);
    void updateTaskName(int taskId, String taskName);
    boolean deleteTaskById(int taskId);
    Optional<Task> findTaskByName(String taskName);
    List<Object[]> groupTasksByCategory();
}
