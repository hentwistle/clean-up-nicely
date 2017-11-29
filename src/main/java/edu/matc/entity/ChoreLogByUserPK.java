package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class ChoreLogByUserPK implements Serializable {
    private int userId;
    private int weekId;
    private int taskId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "week_id", nullable = false)
    @Id
    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    @Column(name = "task_id", nullable = false)
    @Id
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

        ChoreLogByUserPK that = (ChoreLogByUserPK) o;

        if (userId != that.userId) return false;
        if (weekId != that.weekId) return false;
        if (taskId != that.taskId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + weekId;
        result = 31 * result + taskId;
        return result;
    }
}
