package com.salman.tasktracker.mappers;

import com.salman.tasktracker.domain.dto.TaskDto;
import com.salman.tasktracker.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
