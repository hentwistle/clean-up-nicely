package edu.matc.persistence;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class HouseholdHibernateDaoTest {
    HouseholdHibernateDao hhd;
    int listOfHouseholdsInitialSize;

    @Before
    public void setUp() throws Exception {

        hhd = new HouseholdHibernateDao();
        listOfHouseholdsInitialSize = hhd.getAllHouseholds().size();
    }

    @Test
    public void getAllHouseholdsTest() throws Exception {
        List<Household> households = hhd.getAllHouseholds();
        assertTrue(households.size() > 0);
    }

    @Test
    public void getHouseholdTest() throws Exception {
        Household household = (Household) hhd.getHousehold(1);
        assertNotNull(household);
        assertEquals("Purple Palace", household.getHouseholdName());
    }

    @Test
    public void insertHouseholdTest() throws Exception {
        Household household = new Household(10, "Our House");
        int newHousehold = hhd.insert(household);
        assertEquals("Incorrect size of results", listOfHouseholdsInitialSize + 1, hhd.getAllHouseholds().size());
        assertEquals("Household not saved correctly", household, hhd.getHousehold(newHousehold));
    }

    @Test
    public void getHouseholdByUserIdTest() throws Exception {
        Household household = (Household) hhd.getHouseholdByUserId(1);
        assertNotNull(household);
        assertEquals("Purple Palace", household.getHouseholdName());
    }
}
