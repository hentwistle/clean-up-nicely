package edu.matc.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "week")
public class Week {
    private int weekId;
    private Timestamp startDate;
    private Timestamp endDate;

    @Id
    @Column(name = "week_id", nullable = false)
    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Week week = (Week) o;

        if (weekId != week.weekId) return false;
        if (startDate != null ? !startDate.equals(week.startDate) : week.startDate != null) return false;
        if (endDate != null ? !endDate.equals(week.endDate) : week.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weekId;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
