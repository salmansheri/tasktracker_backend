package com.salman.tasktracker.mappers;

import com.salman.tasktracker.domain.dto.TaskListDto;
import com.salman.tasktracker.domain.entities.TaskList;

public interface TaskListMapper {

  TaskList fromDto(TaskListDto taskListDto);

  TaskListDto toDto(TaskList taskList);
}
