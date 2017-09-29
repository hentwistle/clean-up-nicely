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
    private int taskID;

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
     * @param taskID   the ID for the task
     * @param taskName the name for the task
     */
    public Task(int taskID, String taskName) {
        this.taskID = taskID;
        this.taskName = taskName;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID='" + taskID + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }

}
