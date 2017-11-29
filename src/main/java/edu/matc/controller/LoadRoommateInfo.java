package edu.matc.controller;

import edu.matc.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        log.error("the roommate username is: " + req.getParameter("user"));
        log.error(req.getParameterMap());
        log.error("we made it here");
        log.error(req.getPathInfo());
        log.error(req.getContextPath());
        log.error(req.getServletPath());

        //User roommate = req.getParameter("id");
        //req.setAttribute("roommate", roommate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("housemate.jsp");

        dispatcher.forward(req, resp);
    }
}
