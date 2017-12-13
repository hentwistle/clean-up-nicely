package edu.matc.controller;

import edu.matc.entity.ChoreLogByUser;
import edu.matc.entity.Task;
import edu.matc.entity.User;
import edu.matc.entity.Week;
import edu.matc.persistence.ChoreLogHibernateDao;
import edu.matc.persistence.TaskHibernateDao;
import edu.matc.persistence.UserHibernateDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A servlet that loads the info for the household in order to make the pie chart
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/user/loadHouseholdInfo"}
)
public class LoadHouseholdInfo extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //this is not working yet but I would like it to be in the future
        /*ChoreLogByUser choreLogByUser = null;
        Week week = null;

        List<ChoreLogByUser> logs = null;
        List<User> allHousemates = null;

        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();

        week = (Week) req.getSession().getAttribute("week");
        User user = (User) req.getSession().getAttribute("user");

        Map map = new HashMap();

        allHousemates = (ArrayList<User>) req.getSession().getAttribute("housemates");
        allHousemates.add(user);

        for (User housemate : allHousemates) {
            int totalMinutes = 0;

            logs = clhd.getChoreLogEntry(housemate.getUserid(), week.getWeekId());

            for (ChoreLogByUser log : logs) {
                log.getMinutes();
                totalMinutes +=  log.getMinutes();
            }

            map.put(housemate.getUsername(), totalMinutes);

        }

        req.setAttribute("map",  map);*/


        RequestDispatcher dispatcher = req.getRequestDispatcher("household.jsp");

        dispatcher.forward(req, resp);
    }
}
