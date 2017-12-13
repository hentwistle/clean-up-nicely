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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskHibernateDao thd = new TaskHibernateDao();
        ChoreLogHibernateDao clhd = new ChoreLogHibernateDao();
        WeekHibernateDao whd = new WeekHibernateDao();
        List<Task> tasks = null;
        User user =  null;
        Week week = null;
        ChoreLogByUser choreLog = new ChoreLogByUser();
        String minutes = null;
        List<ChoreLogByUser> logs = null;

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

        logs = clhd.getChoreLogEntry(user.getUserid(), week.getWeekId());

        req.getSession().setAttribute("logs", logs);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/choreLogResults.jsp");

        dispatcher.forward(req, resp);
    }

}