package org.architecture.exam.application.usecase;

import org.architecture.exam.domain.dto.TaskDto;
import org.architecture.exam.domain.dto.request.TaskRequest;

import java.util.List;

public interface TaskService {
    TaskDto createNew(TaskRequest taskRequest);
    List<TaskDto> getAll();
    TaskDto getById(String id);
    void delete(TaskRequest taskRequest, String id);
    TaskDto update(TaskRequest taskRequest, String id);
}
