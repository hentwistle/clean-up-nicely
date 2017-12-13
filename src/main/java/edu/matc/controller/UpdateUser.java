package edu.matc.controller;

import edu.matc.entity.Household;
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
        urlPatterns = {"/admin/update"}
)
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("in update user");

        User user = new User();

        UserHibernateDao uhd = new UserHibernateDao();

        //update
        if (req.getParameter("submit").equals("update")) {
            user  = uhd.getUser(req.getParameter("user_name_update").toString());

            if (req.getParameter("first_name_update") != null &&
                    req.getParameter("first_name_update").length() != 0) {
                user.setFirstName(req.getParameter("first_name_update"));
            }

            if (req.getParameter("last_name_update") != null &&
                    req.getParameter("last_name_update").length() != 0) {
                user.setLastName(req.getParameter("last_name_update"));
            }

            if (req.getParameter("email_update") != null &&
                    req.getParameter("email_update").length() != 0) {
                user.setEmail(req.getParameter("email_update"));
            }
            if (req.getParameter("password_update") != null &&
                    req.getParameter("password_update").length() != 0) {
                user.setPassword(req.getParameter("password_update"));
            }

            uhd.update(user);
        } else if (req.getParameter("submit").equals("delete")) {

            //delete
            user  = uhd.getUser(req.getParameter("user_id_delete").toString());
            uhd.delete(user);
        } else if (req.getParameter("submit").equals("add")) {

            //add user
            int newId = uhd.getAllUsers().size() + 1;

            user.setUserid(newId);
            user.setUsername(req.getParameter("user_name"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setFirstName(req.getParameter("first_name"));
            user.setLastName(req.getParameter("last_name"));
            user.setOwner(false);
            uhd.insert(user);
        }

        req.setAttribute("users", uhd.getAllUsers());

        RequestDispatcher dispatcher = req.getRequestDispatcher("results.jsp");

        dispatcher.forward(req, resp);
    }
}
