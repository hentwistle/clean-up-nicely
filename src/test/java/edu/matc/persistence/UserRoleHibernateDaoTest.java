package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.entity.Week;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class UserRoleHibernateDaoTest {
    UserRoleHibernateDao urhd;
    int listOfUserRolesInitialSize;

    @Before
    public void setUp() throws Exception {

        urhd = new UserRoleHibernateDao();
        listOfUserRolesInitialSize = urhd.getAllUserRoles().size();
    }

    @Test
    public void getAllUserRolesTest() throws Exception {
        List<UserRole> userRoles = urhd.getAllUserRoles();
        assertTrue(userRoles.size() > 0);
    }

    @Test
    public void getUserRoleTest() throws Exception {
        UserRole userRole = (UserRole) urhd.getUserRole(2);
        assertNotNull(userRole);
        assertEquals("user", userRole.getRoleName());
    }

    @Test
    public void insertUserRoleTest() throws Exception {
        User user = new User(10, "asmith", "asmith@gmail.com", "passwordsmith", "Amanda", "Smith", false);
        UserRole userRole = new UserRole(10, user, "user");
        int newUser = urhd.insert(userRole);
        assertEquals("Incorrect size of results", listOfUserRolesInitialSize + 1, urhd.getAllUserRoles().size());
    }

    @Test
    public void updateUserRoleTest() throws Exception {
        UserRole userRole = urhd.getUserRole(4);
        listOfUserRolesInitialSize = urhd.getAllUserRoles().size();
        userRole.setRoleName("admin");
        urhd.update(userRole);

        assertEquals("Incorrect size of results", listOfUserRolesInitialSize, urhd.getAllUserRoles().size());
        assertEquals("The userRole was updated incorrectly", "admin", urhd.getUserRole(4).getRoleName());
    }

    @Test
    public void deleteUserRoleTest() throws Exception {

        UserRole userRole = urhd.getUserRole(10);
        urhd.delete(userRole);

        assertEquals("The user was not deleted", 7, urhd.getAllUserRoles().size());
    }

}
