package edu.matc.controller;

import edu.matc.persistence.HouseholdHibernateDao;
import edu.matc.persistence.UserHibernateDao;
import org.apache.log4j.Logger;

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
        urlPatterns = {"/searchHousehold"}
)

public class SearchHousehold extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger log = Logger.getLogger(this.getClass());

        HouseholdHibernateDao hhd = new HouseholdHibernateDao();

        if (req.getParameter("submit").equals("viewAllHouseholds")) {
            req.setAttribute("households", hhd.getAllHouseholds());
        } else {
            req.setAttribute("households", hhd.getHouseholdByUserId(Integer.parseInt(req.getParameter("household_id"))));
            log.error("Error log: " + req.getParameter("household_id"));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/householdResults.jsp");
        dispatcher.forward(req, resp);
    }
}