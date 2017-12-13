package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.Week;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class WeekHibernateDaoTest {
    WeekHibernateDao whd;
    int listOfWeeksInitialSize;

    @Before
    public void setUp() throws Exception {

        whd = new WeekHibernateDao();
        listOfWeeksInitialSize = whd.getAllWeeks().size();
    }

    @Test
    public void getAllWeeksTest() throws Exception {
        List<Week> weeks = whd.getAllWeeks();
        assertTrue(weeks.size() == 52);
    }

    @Test
    public void getWeekByIdTest() throws Exception {
        Week week = (Week) whd.getWeekById(15);
        assertNotNull(week);
        assertEquals("2018-01-22 00:00:00.0", week.getStartDate().toString());
        assertEquals("2018-01-28 23:59:59.0", week.getEndDate().toString());
    }

    @Test
    public void getWeekByDateTest() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ssX");

        Date parsedTimeStamp = dateFormat.parse("2018-01-22 00:00:00.0");
        System.out.println(parsedTimeStamp);

        Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
        System.out.println("week" + timestamp);

        Week week = (Week) whd.getWeekByDate(timestamp);

        assertNotNull(week);
        assertEquals(15, week.getWeekId());
    }

}
