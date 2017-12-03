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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/logout"}
)
public class Logout extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();

        log.error("logged out");
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

        dispatcher.forward(req, resp);
    }
}
