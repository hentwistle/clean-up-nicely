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

    @Test
    public void getChoreLogEntryTest() throws Exception {
        List<ChoreLogByUser> logs = clhd.getChoreLogEntry(1, 9);
        assertNotNull(logs);
        assertEquals(logs.get(1).getMinutes(), 20);
    }


    @Test
    public void getAllLogsByUserTest() throws Exception {
        List<ChoreLogByUser> logs = clhd.getAllLogsByUser(1);

        assertTrue("Incorrect size of results", logs.size() > 0);
    }

    @Test
    public void insertChoreLogTest() throws Exception {
        ChoreLogByUser log = new ChoreLogByUser();
        log.setTaskId(1);
        log.setUserId(3);
        log.setWeekId(9);
        log.setMinutes(29);

        int id = clhd.insert(log);

        assertTrue("No logs are returned for the inserted user",clhd.getAllLogsByUser(1).size() > 0);
    }

    @Test
    public void updateChoreLogTest() throws Exception {
        List<ChoreLogByUser> logs = clhd.getChoreLogEntry(1, 9);

        ChoreLogByUser log = logs.get(3);
        log.setMinutes(45);

        clhd.update(log);

        assertEquals("The log was not updated", ((ChoreLogByUser) clhd.getChoreLogEntry(1, 9).get(3)).getMinutes(), 45);
    }
}
