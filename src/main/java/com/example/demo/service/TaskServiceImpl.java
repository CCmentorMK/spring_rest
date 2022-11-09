package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(String taskName, Optional<User> user){
        Task task = new Task(taskName);
        task.setUser(user.get());                       // do aktualizacji ...
        return taskRepository.save(task);               // INSERT INTO tasks VALUES (?,?,...);
    }
    public List<Task> getTasks(){
        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "taskDeadline"));
                                                        // SELECT * FROM tasks ORDER BY task_deadline DESC;
    }
    public Optional<Task> getTaskById(int taskId){
        return taskRepository.findById(taskId);         // SELECT * FROM tasks WHERE task_id = ?;
    }
    public void updateTaskName(int taskId, String taskName){
        if(getTaskById(taskId).isPresent()){
            Task existingTask = getTaskById(taskId).get();
            existingTask.setTaskName(taskName);
            taskRepository.save(existingTask);          // UPDATE tasks SET task_name = ? WHERE task_id = ?
        }
    }
    public boolean deleteTaskById(int taskId){
        if(getTaskById(taskId).isPresent()){
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }
    public Optional<Task> findTaskByName(String taskName){
        return taskRepository.findTaskByTaskName(taskName);
    }

    @Override
    public List<Object[]> groupTasksByCategory() {
        return null;
    }
}
