package org.architecture.exam.infraestructure.adapter.mapper;

import org.architecture.exam.domain.model.Task;
import org.architecture.exam.infraestructure.adapter.entity.TaskEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDboMapper {
    TaskEntity toDbo(Task domain);
    @InheritInverseConfiguration
    Task toDomain(TaskEntity entity);
}
