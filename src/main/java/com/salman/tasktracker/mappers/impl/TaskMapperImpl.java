package com.salman.tasktracker.mappers.impl;

import com.salman.tasktracker.domain.dto.TaskDto;
import com.salman.tasktracker.domain.entities.Task;
import com.salman.tasktracker.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
        null,
        null,
        null,
                taskDto.priority(),
                taskDto.status(),
                taskDto.dueDate(),
                taskDto.description(),
                taskDto.title()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getTaskList(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
