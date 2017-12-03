package edu.matc.controller;

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
import java.util.Date;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/loadRoommateInfo"}
)
public class LoadRoommateInfo extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.error("setting housemate username to " + req.getSession().getAttribute("housemate"));
        log.error("also setting housemate to " + req.getAttribute("housemate"));
        log.error("param " + req.getParameter("housemate"));
        log.error(req.getServletPath().toString());
        log.error(req.getContextPath().toString());
        log.error(req.getPathInfo().toString());
        log.error(req.getSession().toString());
        log.error(req.getSession().getAttributeNames().toString());
        User roommate = null;
        UserHibernateDao uhd = new UserHibernateDao();
        Week week = null;

        TaskHibernateDao thd = new TaskHibernateDao();
        List<Task> tasks = null;
        List<ChoreLogByUser> logs = null;
        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();
        ChoreLogByUser choreLogByUser = null;

        roommate = uhd.getUser(req.getSession().getAttribute("housemate").toString());
        req.setAttribute("housemate", roommate);

        week = (Week) req.getSession().getAttribute("week");

        tasks = thd.getAllTasks();
        logs = clhd.getChoreLogEntry(roommate.getUserid(), week.getWeekId());


        if (logs.size() == 0) {
            log.info("logs created");
            for (Task task : tasks) {
                choreLogByUser = new ChoreLogByUser();
                choreLogByUser.setMinutes(0);
                choreLogByUser.setUserId(roommate.getUserid());
                choreLogByUser.setWeekId(week.getWeekId());
                choreLogByUser.setTaskId(task.getTaskId());

                clhd.insert(choreLogByUser);
            }
        }

        for (ChoreLogByUser choreLog : logs) {
            choreLogByUser = clhd.getTime(choreLog.getUserId(), choreLog.getWeekId(), choreLog.getTaskId());
        }

        req.setAttribute("housemate_logs", logs);

        /*ChoreLogByUser choreLog = new ChoreLogByUser();
        String minutes = null;
        List<ChoreLogByUser> allLogsForUser = null;

        tasks = thd.getAllTasks();

        for (int i = 1; i < tasks.size(); i++) {
            minutes = req.getParameter(String.valueOf(i));
            choreLog.setUserId(roommate.getUserid());
            choreLog.setWeekId(week.getWeekId());
            choreLog.setTaskId(i);
            choreLog.setMinutes(Integer.parseInt(minutes));
            clhd.update(choreLog);
        } */


        RequestDispatcher dispatcher = req.getRequestDispatcher("housemate.jsp");

        dispatcher.forward(req, resp);
    }
}
