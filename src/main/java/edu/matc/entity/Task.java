package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a task.
 *
 * @author hentwistle
 */
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="task_id")
    private int taskId;

    @Column(name="task_name")
    private String taskName;

    /**
     * Instantiates a new Task.
     */
    public Task() {
    }

    /**
     * Instantiates a new Task.
     *
     * @param taskId   the ID for the task
     * @param taskName the name for the task
     */
    public Task(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "task_name", nullable = true, length = 45)
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }

    @Id
    @Column(name = "task_id", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskId != task.taskId) return false;
        if (taskName != null ? !taskName.equals(task.taskName) : task.taskName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        return result;
    }
}
