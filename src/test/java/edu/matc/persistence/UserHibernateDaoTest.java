package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class UserHibernateDaoTest {
    UserHibernateDao uhd;
    int listOfUsersInitialSize;

    @Before
    public void setUp() throws Exception {

        uhd = new UserHibernateDao();
        listOfUsersInitialSize = uhd.getAllUsers().size();
    }

    /*@Test
    public void getAllUsersTest() throws Exception {
        List<User> users = uhd.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUserTest() throws Exception {
        User user = uhd.getUser(1);
        assertNotNull(user);
        assertEquals("Ennis", user.getLastName());
    }

    @Test
    public void insertUserTest() throws Exception {
        User user = new User(3, "asmith", "asmith@gmail.com", "passwordsmith", "Amanda", "Smith", false);

        int idNewUser = uhd.insert(user);
        assertEquals("Incorrect size of results", listOfUsersInitialSize + 1, uhd.getAllUsers().size());
        assertEquals("User not saved correctly", user.toString(), uhd.getUser(idNewUser).toString());
    }

    @Test
    public void updateUserTest() throws Exception {

        listOfUsersInitialSize = uhd.getAllUsers().size();
        int idOfToBeUpdatedUser = 2;
        User user = uhd.getUser(idOfToBeUpdatedUser);
        user.setLastName("Smith");
        uhd.update(user);

        assertEquals("Incorrect size of results", listOfUsersInitialSize, uhd.getAllUsers().size());
        assertEquals("User not saved correctly", user.toString(), uhd.getUser(idOfToBeUpdatedUser).toString());
    }

    @Test
    public void deleteUserTest() throws Exception {
        User user = uhd.getUser(2);

        uhd.delete(user);

        assertEquals("The user was not deleted", 2, uhd.getAllUsers().size());
    } */
}
