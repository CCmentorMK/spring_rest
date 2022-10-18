package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    public Task addTask(int taskId, String taskName){
        Task task = new Task(taskId, taskName, LocalDateTime.now());
        TaskRepository.TASK_IN_MEMORY.add(task);
        return task;
    }
    public List<Task> getTasks(){
        return TaskRepository.TASK_IN_MEMORY.stream().sorted(Comparator.comparing(Task::getTaskDeadline)).collect(Collectors.toList());
    }
    private Optional<Task> getTaskById(int taskId){
        return TaskRepository.TASK_IN_MEMORY.stream().filter(task -> task.getTaskId() == taskId).findFirst();
    }
    public void updateTaskName(int taskId, String taskName){
        if(getTaskById(taskId).isPresent()){
            getTaskById(taskId).get().setTaskName(taskName);
        }
    }
    public boolean deleteTaskById(int taskId){
        if(getTaskById(taskId).isPresent()){
            TaskRepository.TASK_IN_MEMORY.remove(getTaskById(taskId).get());
            return true;
        }
        return false;
    }
}
