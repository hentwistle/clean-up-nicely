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
 * A simple servlet to load the user's roommates' chores info
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/user/loadRoommateInfo"}
)
public class LoadRoommateInfo extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User housemate = null;
        Week week = null;
        ChoreLogByUser choreLogByUser = null;

        UserHibernateDao uhd = new UserHibernateDao();
        TaskHibernateDao thd = new TaskHibernateDao();
        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();

        List<Task> tasks = null;
        List<ChoreLogByUser> logs = null;

        housemate = uhd.getUser(req.getParameter("housemate"));
        req.setAttribute("housemate", housemate);

        week = (Week) req.getSession().getAttribute("week");

        tasks = thd.getAllTasks();
        logs = clhd.getChoreLogEntry(housemate.getUserid(), week.getWeekId());


        //create housemate logs if they don't exist
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
