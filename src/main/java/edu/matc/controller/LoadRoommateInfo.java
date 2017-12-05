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

        log.error("param " + req.getParameter("housemate"));
        User housemate = null;
        UserHibernateDao uhd = new UserHibernateDao();
        Week week = null;

        TaskHibernateDao thd = new TaskHibernateDao();
        List<Task> tasks = null;
        List<ChoreLogByUser> logs = null;
        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();
        ChoreLogByUser choreLogByUser = null;

        housemate = uhd.getUser(req.getParameter("housemate"));
        req.setAttribute("housemate", housemate);

        week = (Week) req.getSession().getAttribute("week");

        tasks = thd.getAllTasks();
        logs = clhd.getChoreLogEntry(housemate.getUserid(), week.getWeekId());


        if (logs.size() == 0) {
            log.info("logs created");
            for (Task task : tasks) {
                choreLogByUser = new ChoreLogByUser();
                choreLogByUser.setMinutes(0);
                choreLogByUser.setUserId(housemate.getUserid());
                choreLogByUser.setWeekId(week.getWeekId());
                choreLogByUser.setTaskId(task.getTaskId());

                clhd.insert(choreLogByUser);

                logs = clhd.getChoreLogEntry(housemate.getUserid(), week.getWeekId());
            }
        }

        req.setAttribute("housemate_logs", logs);

        RequestDispatcher dispatcher = req.getRequestDispatcher("housemate.jsp");

        dispatcher.forward(req, resp);
    }
}
