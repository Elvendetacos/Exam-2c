package org.architecture.exam.domain.port;

import org.apache.catalina.User;
import org.architecture.exam.domain.model.Task;

import java.util.List;

public interface TaskPort {
    Task create(Task task);
    List<Task> getAll();
    Task getById(String id);
    void delete(Task task, String id);
    Task update(Task task, String id);
}
