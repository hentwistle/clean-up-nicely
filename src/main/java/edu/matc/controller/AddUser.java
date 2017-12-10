package edu.matc.controller;

import edu.matc.entity.User;
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

        User user = new User();
        UserHibernateDao uhd = new UserHibernateDao();

        log.error(req.getParameter("username"));
        log.error(req.getParameter("email"));
        log.error(req.getParameter("password"));
        log.error(req.getParameter("first_name"));
        log.error(req.getParameter("last_name"));
        log.error(uhd.getAllUsers().size());

        user.setUserid(uhd.getAllUsers().size() + 1);
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setFirstName(req.getParameter("first_name"));
        user.setLastName(req.getParameter("last_name"));
        user.setOwner(false);

        if (req.getParameter("submit").equals("add")) {
            uhd.insert(user);
        }
        req.setAttribute("user", user);

        if (req.getUserPrincipal() == null) {
            req.getSession(); // create session before logging in
            req.login(user.getUsername(), user.getPassword());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("user/login");

        dispatcher.forward(req, resp);
    }
}
