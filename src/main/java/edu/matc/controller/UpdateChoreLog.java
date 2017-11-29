package edu.matc.controller;

import edu.matc.entity.*;
import edu.matc.persistence.*;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveChores")
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


        //allLogsForUser = clhd.getAllLogsByUser(user.getUserid());

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
        req.setAttribute("weeks", whd.getAllWeeks());

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