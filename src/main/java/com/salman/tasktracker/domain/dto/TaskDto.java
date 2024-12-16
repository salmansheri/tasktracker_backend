package com.salman.tasktracker.domain.dto;

import com.salman.tasktracker.domain.entities.TaskList;
import com.salman.tasktracker.domain.entities.TaskPriorityEnum;
import com.salman.tasktracker.domain.entities.TaskStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        TaskList taskList,
        LocalDateTime dueDate,
        TaskPriorityEnum priority,
        TaskStatusEnum status


) {

}
