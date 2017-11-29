package edu.matc.controller;

import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserHibernateDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger log = Logger.getLogger(this.getClass());
        log.error("here");

        UserHibernateDao uhd = new UserHibernateDao();
        if (req.getParameter("submit").equals("search")) {
            //req.setAttribute("users", uhd.getUser( Integer.parseInt(req.getParameter("searchTerm"))));
        } else if (req.getParameter("submit").equals("users_by_household_id")) {
            req.setAttribute("users", uhd.getUsersByHousehold( Integer.parseInt(req.getParameter("users_by_household_id"))));
           } else {
            req.setAttribute("users", uhd.getAllUsers());

        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}