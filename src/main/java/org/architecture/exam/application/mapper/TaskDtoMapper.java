package org.architecture.exam.application.mapper;

import org.architecture.exam.domain.dto.TaskDto;
import org.architecture.exam.domain.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {
    TaskDto toDto(Task domain);
}
