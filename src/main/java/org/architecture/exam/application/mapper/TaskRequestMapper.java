package org.architecture.exam.application.mapper;

import org.architecture.exam.domain.dto.request.TaskRequest;
import org.architecture.exam.domain.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TaskRequestMapper {
    Task toDomain(TaskRequest request);
}
