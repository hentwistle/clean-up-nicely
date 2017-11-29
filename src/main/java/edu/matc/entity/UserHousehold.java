package edu.matc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_household", schema = "mydb", catalog = "")
@IdClass(UserHousehold.class)
public class UserHousehold implements Serializable {
    private int userId;
    private int householdId;
    private Household householdByHouseholdId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "household_id", nullable = false)
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

        UserHousehold that = (UserHousehold) o;

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

    /* @ManyToOne
    @JoinColumn(name = "household_id", referencedColumnName = "household_id", nullable = false)
    public Household getHouseholdByHouseholdId() {
        return householdByHouseholdId;
    }

    public void setHouseholdByHouseholdId(Household householdByHouseholdId) {
        this.householdByHouseholdId = householdByHouseholdId;
    } */


}
