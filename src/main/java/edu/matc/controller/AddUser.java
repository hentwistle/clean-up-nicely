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
 * A simple servlet to welcome the user.
 * @author hentwistle
 */

@WebServlet(
        urlPatterns = {"/addUser"}
)
public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUsername(req.getParameter("user_name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setFirstName(req.getParameter("first_name"));
        user.setLastName(req.getParameter("last_name"));
        user.setOwner(false);

        UserHibernateDao uhd = new UserHibernateDao();
        if (req.getParameter("submit").equals("add")) {
            req.setAttribute("users", uhd.insert(user));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addResults.jsp");

        dispatcher.forward(req, resp);
    }
}
