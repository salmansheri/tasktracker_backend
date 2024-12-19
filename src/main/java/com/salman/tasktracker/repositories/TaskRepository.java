package com.salman.tasktracker.repositories;


import com.salman.tasktracker.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID taskListId); // Custom query to get all tasks by task list id
    Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id); // Custom query to get a task by task list id and task id

}
