package edu.matc.persistence;

import edu.matc.entity.ChoreLogByUser;
import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ChoreLogHibernateDaoTest {
    ChoreLogHibernateDao clhd;
    int listOfChoreLogsInitialSize;

    @Before
    public void setUp() throws Exception {

        clhd = new ChoreLogHibernateDao();
        listOfChoreLogsInitialSize = clhd.getAllChoreLogs().size();
    }

    @Test
    public void getAllChoreLogsTest() throws Exception {
        List<ChoreLogByUser> logs = clhd.getAllChoreLogs();
        assertTrue(logs.size() > 0);
    }
/*
    @Test
    public void getUserTest() throws Exception {
        User user = (User) uhd.getUser("hentwistle");
        assertNotNull(user);
        assertEquals("Entwistle", user.getLastName());
    }

    @Test
    public void insertUserTest() throws Exception {
        User user = new User(10, "asmith", "asmith@gmail.com", "passwordsmith", "Amanda", "Smith", false);

        String newUserName = uhd.insert(user);
        assertEquals("Incorrect size of results", listOfUsersInitialSize + 1, uhd.getAllUsers().size());
        assertEquals("User not saved correctly", user.toString(), uhd.getUser(newUserName).toString());
    }

    @Test
    public void updateUserTest() throws Exception {

        listOfUsersInitialSize = uhd.getAllUsers().size();
        String nameOfToBeUpdatedUser = "cring";
        User user = (User) uhd.getUser(nameOfToBeUpdatedUser);
        user.setLastName("Smith");
        uhd.update(user);

        assertEquals("Incorrect size of results", listOfUsersInitialSize, uhd.getAllUsers().size());
        assertEquals("User not saved correctly", user.toString(), uhd.getUser(nameOfToBeUpdatedUser).toString());
    }

    @Test
    public void deleteUserTest() throws Exception {
        User user = uhd.getUser("christi");

        uhd.delete(user);

        assertEquals("The user was not deleted", 8, uhd.getAllUsers().size());
    }

    @Test
    public void getAllUsersByHouseholdTest() throws Exception {
        List<User> users = uhd.getAllUsersByHousehold(1);

        assertEquals("You returned an unexpected number of household members", 3, users.size());
    } */

}
