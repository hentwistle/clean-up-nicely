package edu.matc.controller;

import com.sun.media.jfxmedia.logging.Logger;
import edu.matc.entity.*;
import edu.matc.persistence.*;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * A servlet that either logs in in the returning user or
 * signs up a new user.
 *
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/user/login"}
)
public class Login extends HttpServlet {
    UserHibernateDao uhd = new UserHibernateDao();
    WeekHibernateDao whd = new WeekHibernateDao();
    TaskHibernateDao thd = new TaskHibernateDao();
    HouseholdHibernateDao hhd = new HouseholdHibernateDao();
    ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();

    User user = null;
    Household household = null;
    Week week = null;
    ChoreLogByUser choreLogByUser = null;
    Date date = null;

    List<User> housemates = null;
    List<Week> weeks = null;
    List<Task> tasks = null;
    List<ChoreLogByUser> logs = null;

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //coming from login
        log.error("logging in existing user");

        //get user and set variables based on that
        user  = uhd.getUser(req.getRemoteUser());

        //add household
        processRequest(user, req, resp);

    }

    /**
     * Takes the input user and gets the current week, initializes chore logs or gets
     * them if they already exist, and sets the necessary request attributes to be
     * sent on to the next page.
     *
     * @param user the current user
     */
    private void processRequest(User user, HttpServletRequest req, HttpServletResponse resp) {
        String dispatchString = "";

        household = hhd.getHouseholdByUserId(user.getUserid());
        housemates = uhd.getAllUsersByHousehold(household.getHouseholdId());
        housemates.remove(user.getUserid() - 1);
        tasks = thd.getAllTasks();

        //get the current date
        date = getDate();

        //set the week to align with the current date
        week = getWeekFromDatabase(date);

        //get the logs from the database
        logs = clhd.getChoreLogEntry(user.getUserid(), week.getWeekId());

        //if they don't exist, create them
        if (logs.size() == 0) {
            createChoreLogsForWeek(logs);
        }

        //for each chore, get the time entered in the database if it has already been entered
        for (ChoreLogByUser choreLog : logs) {
            choreLogByUser = clhd.getTime(choreLog.getUserId(), choreLog.getWeekId(), choreLog.getTaskId());
        }

        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("household", household);
        req.getSession().setAttribute("housemates", housemates);
        req.getSession().setAttribute("week", week);
        req.getSession().setAttribute("start_date", formatDate(week.getStartDate()));
        req.getSession().setAttribute("end_date", formatDate(week.getEndDate()));
        req.getSession().setAttribute("logs", logs);
        req.getSession().setAttribute("tasks", tasks);

        dispatchString = "main.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchString);

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException se) {
            log.error("servlet exception " + se);
        } catch (IOException ioe) {
            log.error("ioexception " + ioe);
        }


    }

    /**
     * If the chore logs for this week don't currently exist in the database,
     * this method creates them.
     *
     * @param logs the list of chore log entries for this user
     * @return the logs after they've been initialized with data
     */
    private List<ChoreLogByUser> createChoreLogsForWeek(List<ChoreLogByUser> logs) {
        log.info("logs created");
        for (Task task : tasks) {
            choreLogByUser = new ChoreLogByUser();
            choreLogByUser.setMinutes(0);
            choreLogByUser.setUserId(user.getUserid());
            choreLogByUser.setWeekId(week.getWeekId());
            choreLogByUser.setTaskId(task.getTaskId());

            clhd.insert(choreLogByUser);

        }

        logs = clhd.getChoreLogEntry(user.getUserid(), week.getWeekId());

        return logs;
    }

    /**
     * Takes the date that was retrieved and looks in the database for the
     * corresponding week.
     *
     * @param date  the current date
     * @return the current week
     */
    private Week getWeekFromDatabase(Date date) {
        weeks = whd.getAllWeeks();

        for (Week testWeek : weeks) {

            if (date.before(testWeek.getEndDate()) && date.after(testWeek.getStartDate())) {
                week = whd.getWeekById(testWeek.getWeekId());
                log.error("the week is getting set to week " + week.getWeekId());
            }
        }

        return week;
    }

    /**
     * gets the current date
     *
     * @return date     the date of the current week
     */
    private String formatDate(Date date) {
        String dateString = new SimpleDateFormat("MMMMM dd, yyyy").format(date);
        return dateString;
    }

    /**
     * gets the current date
     *
     * @return date     the date of the current week
     */
    private Date getDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return date;
    }
}
