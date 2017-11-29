package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserHouseholdPK implements Serializable {
    private int userId;
    private int householdId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "household_id", nullable = false)
    @Id
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHouseholdPK that = (UserHouseholdPK) o;

        if (userId != that.userId) return false;
        if (householdId != that.householdId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + householdId;
        return result;
    }
}
