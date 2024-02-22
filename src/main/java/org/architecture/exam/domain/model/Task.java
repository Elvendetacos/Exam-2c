package org.architecture.exam.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.architecture.exam.domain.model.vo.Status;

import java.util.Date;

@Getter @Setter
public class Task {
    private String uuid;
    private String name;
    private String description;
    private Status status;
}
