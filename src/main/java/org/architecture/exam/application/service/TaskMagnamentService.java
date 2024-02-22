package org.architecture.exam.application.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.architecture.exam.application.mapper.TaskDtoMapper;
import org.architecture.exam.application.mapper.TaskRequestMapper;
import org.architecture.exam.application.usecase.TaskService;
import org.architecture.exam.domain.dto.TaskDto;
import org.architecture.exam.domain.dto.request.TaskRequest;
import org.architecture.exam.domain.model.Task;
import org.architecture.exam.domain.model.vo.Status;
import org.architecture.exam.domain.port.TaskPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskMagnamentService implements TaskService {
    private final TaskPort taskPort;
    private final TaskDtoMapper mapperDto;
    private final TaskRequestMapper mapperRequest;

    public TaskMagnamentService(final TaskPort taskPort, final TaskDtoMapper mapperDto, final TaskRequestMapper mapperRequest) {
        this.taskPort = taskPort;
        this.mapperDto = mapperDto;
        this.mapperRequest = mapperRequest;
    }

    @Override
    public TaskDto getById(String id) {
        var user = taskPort.getById(id);
        return mapperDto.toDto(user);
    }

    @Override
    public TaskDto createNew(TaskRequest taskRequest) {
        var task = mapperRequest.toDomain(taskRequest);
        var createdTask = taskPort.create(task);
        return mapperDto.toDto(createdTask);
    }

    @Override
    public List<TaskDto> getAll() {
        var tasks = taskPort.getAll();
        return tasks
                .stream()
                .map(mapperDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(TaskRequest taskRequest, String id) {
        var user = taskPort.getById(id);
        user.setStatus(Status.COMPLETE);
        var completeTask = mapperRequest.toDomain(taskRequest);
        taskPort.update(completeTask, id);
    }

    @Override
    public TaskDto update(TaskRequest taskRequest, String id) {
        var task = mapperRequest.toDomain(taskRequest);
        var updatedTask = taskPort.update(task, id);
        return mapperDto.toDto(updatedTask);
    }
}
