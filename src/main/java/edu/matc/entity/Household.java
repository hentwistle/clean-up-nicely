package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a household.
 *
 * @author hentwistle
 */
@Entity
@Table(name = "household")
public class Household {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="household_id")
    private int householdId;

    @Column(name="household_name")
    private String householdName;

    private Set<User> usersByHouseholdId = new HashSet<User>(0);

    /**
     * Instantiates a new Household.
     */
    public Household() {
    }

    /**
     * Instantiates a new Household.
     *
     * @param householdId   the ID for the household
     * @param householdName the name for the household
     */
    public Household(int householdId, String householdName) {
        this.householdId = householdId;
        this.householdName = householdName;
    }

    @Id
    @Column(name = "household_id", nullable = false)
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    //@Basic
    @Column(name = "household_name", nullable = true, length = 45)
    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    @Override
    public String toString() {
        return "Household{" +
                "householdId='" + householdId + '\'' +
                ", householdName='" + householdName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Household household = (Household) o;

        if (householdId != household.householdId) return false;
        if (householdName != null ? !householdName.equals(household.householdName) : household.householdName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = householdId;
        result = 31 * result + (householdName != null ? householdName.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<User> getUsersByHouseholdId() {
        return this.usersByHouseholdId;
    }

    public void setUsersByHouseholdId(Set<User> usersByHouseholdId) {
        this.usersByHouseholdId = usersByHouseholdId;
    }
}