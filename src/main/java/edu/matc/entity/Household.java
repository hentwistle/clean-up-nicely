package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private int householdID;

    @Column(name="household_name")
    private String householdName;

    /**
     * Instantiates a new Household.
     */
    public Household() {
    }

    /**
     * Instantiates a new Household.
     *
     * @param householdID   the ID for the household
     * @param householdName the name for the household
     */
    public Household(int householdID, String householdName) {
        this.householdID = householdID;
        this.householdName = householdName;
    }

    public int getHouseholdID() {
        return householdID;
    }

    public void setHouseholdID(int householdID) {
        this.householdID = householdID;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    @Override
    public String toString() {
        return "Household{" +
                "householdID='" + householdID + '\'' +
                ", householdName='" + householdName + '\'' +
                '}';
    }

}
