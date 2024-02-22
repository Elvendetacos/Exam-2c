package org.architecture.exam.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.architecture.exam.domain.model.vo.Status;

import java.util.Date;

@Getter @Setter
public class TaskDto {
    private String id;
    private String name;
    private String description;
    private Status status;
}
