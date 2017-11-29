package edu.matc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chore_log_by_user", schema = "mydb")
public class ChoreLogByUser implements Serializable{
    @Basic
    @Column(name = "minutes", nullable = true)
    private int minutes;

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Id
    @Column(name = "week_id", nullable = false)
    private int weekId;

    @Id
    @Column(name = "task_id", nullable = false)
    private int taskId;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

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

        ChoreLogByUser that = (ChoreLogByUser) o;

        if (userId != that.userId) return false;
        if (weekId != that.weekId) return false;
        if (taskId != that.taskId) return false;
        if (minutes != that.minutes) return false;

        return true;
    }

    /*
    @Override
    public int hashCode() {
        int result = minutes != null ? minutes.hashCode() : 0;
        result = 31 * result + userId;
        result = 31 * result + weekId;
        result = 31 * result + taskId;
        return result;
    } */
}
