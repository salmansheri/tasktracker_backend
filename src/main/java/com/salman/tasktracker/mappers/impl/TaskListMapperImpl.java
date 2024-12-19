package com.salman.tasktracker.mappers.impl;

import com.salman.tasktracker.domain.dto.TaskListDto;
import com.salman.tasktracker.domain.entities.Task;
import com.salman.tasktracker.domain.entities.TaskList;
import com.salman.tasktracker.domain.entities.TaskStatusEnum;
import com.salman.tasktracker.mappers.TaskListMapper;
import com.salman.tasktracker.mappers.TaskMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskList fromDto(TaskListDto taskListDto) {

        return new TaskList(
                taskListDto.id(),
                null,
                null,
                Optional.ofNullable(taskListDto.tasks())
                                .map(tasks -> tasks.stream().map(taskMapper::fromDto)
                                        .toList()
                                ).orElse(null),
                taskListDto.description(),
                taskListDto.title()
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0), // calculate task count
                calculateTaskListProgress(taskList.getTasks()), // calculate progress
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream().map(taskMapper::toDto)
                                .toList()
                        ).orElse(null)


        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if(null == tasks) {
            return null; // no tasks
        }

       long closedTaskCount  =  tasks.stream().filter(task -> TaskStatusEnum.CLOSED == task.getStatus()).count();

        return (double) closedTaskCount / tasks.size();


    }


}
