package org.architecture.exam.infraestructure.rest.controller;

import org.architecture.exam.application.usecase.TaskService;
import org.architecture.exam.domain.dto.TaskDto;
import org.architecture.exam.domain.dto.request.TaskRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List<TaskDto> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable String id){
        return taskService.getById(id);
    }

    @PostMapping()
    public TaskDto create(@RequestBody TaskRequest taskDto){
        return taskService.createNew(taskDto);
    }

    @PutMapping("/update/{id}")
    public TaskDto update(@RequestBody TaskRequest taskRequest, @PathVariable String id){
        return taskService.update(taskRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestBody TaskRequest taskRequest,@PathVariable String id){
        taskService.delete(taskRequest, id);
    }

}
