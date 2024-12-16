package com.salman.tasktracker.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    private UUID id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="title")
    private String description;
    @Column(name="due_date")
    private LocalDateTime dueDate;

    @Column(name="status", nullable = false)
    private TaskStatusEnum status;

    @Column(name="task_priority", nullable = false)
    private TaskPriorityEnum priority;

    @Column(name="created_at", nullable=false)
    private LocalDate createdAt;
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Task() {
    }

    public Task(UUID id, LocalDateTime updatedAt, LocalDate createdAt, TaskPriorityEnum priority, TaskStatusEnum status, LocalDateTime dueDate, String description, String title) {
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public TaskPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(TaskPriorityEnum priority) {
        this.priority = priority;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && status == task.status && priority == task.priority && Objects.equals(createdAt, task.createdAt) && Objects.equals(updatedAt, task.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, status, priority, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Task{" +
                "updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", priority=" + priority +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
