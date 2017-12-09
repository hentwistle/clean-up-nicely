package edu.matc.controller;

import edu.matc.entity.*;
import edu.matc.persistence.*;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@WebServlet("/user/saveChores")
public class UpdateChoreLog extends HttpServlet {
    //private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskHibernateDao thd = new TaskHibernateDao();
        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();
        WeekHibernateDao whd = new WeekHibernateDao();
        List<Task> tasks = null;
        User user =  null;
        Week week = null;
        ChoreLogByUser choreLog = new ChoreLogByUser();
        String minutes = null;
        List<ChoreLogByUser> allLogsForUser = null;

        tasks = thd.getAllTasks();
        user = (User) req.getSession().getAttribute("user");
        week = (Week) req.getSession().getAttribute("week");

        for (int i = 1; i < tasks.size(); i++) {
            minutes = req.getParameter(String.valueOf(i));
            choreLog.setUserId(user.getUserid());
            choreLog.setWeekId(week.getWeekId());
            choreLog.setTaskId(i);
            choreLog.setMinutes(Integer.parseInt(minutes));
            clhd.update(choreLog);
        }

        allLogsForUser = clhd.getAllLogsByUser(user.getUserid());

        Set<Week> uniqueWeeks = new HashSet<Week>();
        List<ChoreLogByUser> choreLogsByWeek = null;

        for (ChoreLogByUser log : allLogsForUser) {
               uniqueWeeks.add(whd.getWeekById(log.getWeekId()));
        }

        List orderedList = new ArrayList(uniqueWeeks);
        //Collections.sort(orderedList);


        for (int i = 0; i < orderedList.size(); i++ ) {
            int weekId = ((Week) orderedList.get(i)).getWeekId();
                choreLogsByWeek = clhd.getChoreLogEntry(user.getUserid(), weekId);
                req.setAttribute("chore_week", choreLogsByWeek);


        }

        //for (Week week2: uniqueWeeks) {
//

  //          choreLogsByWeek = clhd.getChoreLogEntry(user.getUserid(), week2.getWeekId());
    //        req.setAttribute("chores_week_" + week2.getWeekId(), choreLogsByWeek);
      //  }

        /*//for each week
        for (int i = 1; i <allLogsForUser.size(); i++) {
            String startDate = null;
            String endDate = null;
            String output = null;
            WeekHibernateDao whd = new WeekHibernateDao();
            ChoreLogByUser log = null;

            log = (ChoreLogByUser) clhd.getChoreLogEntry(user.getUserid(), i);
            Week testWeek = null;
            testWeek = whd.getWeekById(i);
            startDate = testWeek.getStartDate().toString();
            System.out.println("start date string" + startDate);

        } */



        /*for (int i = 1; i < allLogsForUser.size(); i++) {
            String startDate;
            String endDate;
            List<String> outputString;
            WeekHibernateDao whd = new WeekHibernateDao();

            startDate = whd.getWeekById();

        } */

        req.setAttribute("all_logs", allLogsForUser);
        req.setAttribute("unique_weeks", orderedList);




        //clhd.getAllChoreLogs();

        /*List <Week> weeks = null;
        for (ChoreLogByUser cl : clhd.getAllChoreLogs()) {

            cl.getWeekId();

            if (cl.getWeekId() )


        } */

        RequestDispatcher dispatcher = req.getRequestDispatcher("/archive.jsp");

        dispatcher.forward(req, resp);
    }

}