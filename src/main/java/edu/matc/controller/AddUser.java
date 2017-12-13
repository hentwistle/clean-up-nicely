package edu.matc.controller;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import edu.matc.persistence.HouseholdHibernateDao;
import edu.matc.persistence.UserHibernateDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to add a user.
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/addUser"}
)
public class AddUser extends HttpServlet {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //this is not currently being used but I wanted to keep it in case I want to work on things more later

     /*
        User user = new User();
        Household household = new Household();
        UserHibernateDao uhd = new UserHibernateDao();
        HouseholdHibernateDao hhd = new HouseholdHibernateDao();

        user.setUserid(uhd.getAllUsers().size() + 1);
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setFirstName(req.getParameter("first_name"));
        user.setLastName(req.getParameter("last_name"));
        user.setOwner(false);

        log.error(req.getParameter("household"));
        if (req.getParameter("household").equals("existing")) {
            log.error("adding user to existing household");
            User requiredHousemate = new User();
            requiredHousemate = uhd.getUser(req.getParameter("housemate_name"));
            log.error("required housemate name: " + requiredHousemate.getUsername());

            //log.error("important household information: " + requiredHousemate.getHousehold());
            //log.error("important household information: " + hhd.getHouseholdByUserId(requiredHousemate.getUserid()));
            //log.error("important roommate information: " + requiredHousemate.getHousehold().getUsers());

            hhd.getHouseholdByUserId(requiredHousemate.getUserid());
            log.error("household retrieved: " + hhd.getHouseholdByUserId(requiredHousemate.getUserid()));
            int householdId = hhd.getHouseholdByUserId(requiredHousemate.getUserid()).getHouseholdId();

            log.error("household id set to " + householdId);
            household.setHouseholdId(householdId);
            user.setHousehold(hhd.getHousehold(householdId));
            log.error("user household: " + user.getHousehold().getHouseholdId());
            //log.error("user roommates: " + user.getHousehold().getUsers());
        } else {
            log.error("adding user to new household");
            household.setHouseholdId(hhd.getAllHouseholds().size() + 1);

            if (!req.getParameter("household_name").equals(null)) {
                household.setHouseholdName(req.getParameter("household_name"));
            } else {
                household.setHouseholdName("");
            }
        }


        log.error("user household 2: " + user.getHousehold().getHouseholdId());
        if (req.getParameter("submit").equals("add")) {
            uhd.insert(user);
            log.error("inserted user: " + user.toString());
            log.error("double check: " + uhd.getUser(user.getUsername()));
            log.error("household: " + user.getHousehold().getHouseholdId());
            household.setHouseholdId(user.getHousehold().getHouseholdId());
            household.setHouseholdName(user.getHousehold().getHouseholdName());
            hhd.insert(household);
            log.error("household: " + hhd.getHousehold(household.getHouseholdId()));
        }
        req.setAttribute("user", user);

        if (req.getUserPrincipal() == null) {
            req.getSession(); // create session before logging in
            log.error("login username " + user.getUsername());
            log.error("login password " + user.getPassword());
            req.login(user.getUsername(), user.getPassword());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("user/login");

        dispatcher.forward(req, resp); */
    }
}
