package org.architecture.exam.infraestructure.adapter;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.architecture.exam.domain.model.Task;
import org.architecture.exam.domain.port.TaskPort;
import org.architecture.exam.infraestructure.adapter.mapper.TaskDboMapper;
import org.architecture.exam.infraestructure.adapter.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskAdapter implements TaskPort {
    private final TaskRepository taskRepository;
    private final TaskDboMapper taskDboMapper;

    public TaskAdapter(TaskRepository taskRepository, TaskDboMapper taskDboMapper) {
        this.taskRepository = taskRepository;
        this.taskDboMapper = taskDboMapper;
    }


    @Override
    public Task create(Task task) {
        var taskEntity = taskDboMapper.toDbo(task);
        var taskSaved = taskRepository.save(taskEntity);
        return taskDboMapper.toDomain(taskSaved);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll().stream().map(taskDboMapper::toDomain).toList();
    }

    @Override
    public Task getById(String id) {
        var optionalTask = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return taskDboMapper.toDomain(optionalTask);
    }

    @Override
    public void delete(Task task, String id) {
        var taskFound = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        taskRepository.save(taskFound);
    }

    @Override
    public Task update(Task task, String id) {
        var taskFound = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        taskRepository.save(taskFound);
        return taskDboMapper.toDomain(taskFound);
    }
}
