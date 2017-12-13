package edu.matc.persistence;

import edu.matc.entity.Task;
import edu.matc.entity.Week;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class TaskHibernateDaoTest {
    TaskHibernateDao thd;
    int listOfTasksInitialSize;

    @Before
    public void setUp() throws Exception {

        thd = new TaskHibernateDao();
        listOfTasksInitialSize = thd.getAllTasks().size();
    }

    @Test
    public void getAllTasksTest() throws Exception {
        List<Task> tasks = thd.getAllTasks();
        assertEquals("The tasks list is the wrong size", tasks.size(), 21);
    }

    @Test
    public void getTask() throws Exception {
        Task task = (Task) thd.getTask(4);
        assertNotNull(task);
        assertEquals("Clean bathroom", task.getTaskName());
    }

}
