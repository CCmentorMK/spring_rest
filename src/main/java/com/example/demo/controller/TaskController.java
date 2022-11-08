package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private TaskServiceImpl taskService;
    private UserServiceImpl userService;
    // DI
    @Autowired
    public TaskController(TaskServiceImpl taskService, UserServiceImpl userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/task")
    public Task addTask(
            @RequestParam("userId") int userId,
            @RequestParam("taskName") String taskName){

        return taskService.addTask(taskName, userService.findUserById(userId));
    }
    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }
    @PutMapping("/task/{taskId}")
    public void updateTask(
            @PathVariable("taskId") int taskId,
            @RequestParam("taskName") String taskName
            ){
        taskService.updateTaskName(taskId, taskName);
    }
    @DeleteMapping("/tasks/{taskId}")
    public boolean deleteTask(@PathVariable("taskId") int taskId){
        return taskService.deleteTaskById(taskId);
    }

    @GetMapping("/tasks/{task_name}")
    public Task findTaskByName(@PathVariable("task_name") String taskName){
        return taskService.findTaskByName(taskName).orElse(new Task());
    }

}
