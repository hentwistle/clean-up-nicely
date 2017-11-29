package edu.matc.controller;

import com.sun.media.jfxmedia.logging.Logger;
import edu.matc.entity.*;
import edu.matc.persistence.ChoreLogHibernateDao;
import edu.matc.persistence.TaskHibernateDao;
import edu.matc.persistence.UserHibernateDao;
import edu.matc.persistence.WeekHibernateDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * A simple servlet to welcome the user.
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dispatchString = "";
        UserHibernateDao uhd = new UserHibernateDao();
        User user = null;
        Household household = null;
        List<User> housemates = null;
        WeekHibernateDao whd = new WeekHibernateDao();
        Week week = null;
        List<Week> weeks = null;
        TaskHibernateDao thd = new TaskHibernateDao();
        List<Task> tasks = null;
        List<ChoreLogByUser> logs = null;
        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();
        ChoreLogByUser choreLogByUser = null;
        Date date = null;

        date = getDate();

        user  = uhd.getUser(req.getParameter("username"));
        household = uhd.getHouseholdByUserId(user.getUserid());
        housemates = uhd.getAllUsersByHousehold(household.getHouseholdId());
        log.error("size of housemates " + housemates.size());
        housemates.remove(user.getUserid() - 1);
        log.error("size of housemates " + housemates.size());
        //week = whd.getWeekById(6);
        weeks = whd.getAllWeeks();
        log.error(weeks.toString());

        for (Week testWeek : weeks) {

            if (date.before(testWeek.getEndDate()) && date.after(testWeek.getStartDate())) {
                week = whd.getWeekById(testWeek.getWeekId());
                break;
            }
        }

        tasks = thd.getAllTasks();
        logs = clhd.getChoreLogEntry(user.getUserid(), week.getWeekId());


        if (logs.size() == 0) {
            log.info("logs created");
            for (Task task : tasks) {
                choreLogByUser = new ChoreLogByUser();
                choreLogByUser.setMinutes(0);
                choreLogByUser.setUserId(user.getUserid());
                choreLogByUser.setWeekId(week.getWeekId());
                choreLogByUser.setTaskId(task.getTaskId());

                clhd.insert(choreLogByUser);
            }
        }

        for (ChoreLogByUser choreLog : logs) {
            choreLogByUser = clhd.getTime(choreLog.getUserId(), choreLog.getWeekId(), choreLog.getTaskId());
        }


        if (req.getParameter("submit").equals("signIn")) {
            String inputPassword = req.getParameter("password");
            String userPassword = user.getPassword();

            if (inputPassword.equals(userPassword)) {
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("household", household);
                req.getSession().setAttribute("housemates", housemates);
                req.getSession().setAttribute("week", week);
                req.setAttribute("logs", logs);
                req.setAttribute("tasks", tasks);

                dispatchString = "main.jsp";
            } else {
                log.error("your password does not match");
            }

        } else if (req.getParameter("submit").equals("signUp")) {
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            log.error("you are passing through a user with username " + user.getUsername() + " and password " + user.getPassword());
            dispatchString = "signUp.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchString);

        dispatcher.forward(req, resp);
    }

    private Date getDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return date;
    }
}
