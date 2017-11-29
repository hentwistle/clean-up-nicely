package edu.matc.controller;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import edu.matc.persistence.GenericServiceImpl;
import edu.matc.persistence.IGenericService;
import edu.matc.persistence.SessionFactoryProvider;
import edu.matc.persistence.UserHibernateDao;
import edu.matc.utility.HibernateUtil;

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
        urlPatterns = {"/updateUser"}
)
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user =null;
        Household household=null;

        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());
        IGenericService<Household> householdService = new GenericServiceImpl<Household>(
                Household.class, HibernateUtil.getSessionFactory());
        //userService.deleteAll();

        if (req.getParameter("submit").equals("update")) {
            user = new User();
            user.setUserid(1);
            user.setUsername("hentwistle2");
            userService.save(user);
        }



        //UserHibernateDao uhd = new UserHibernateDao();

        //User user;

        //user  = uhd.getUser(Integer.parseInt(req.getParameter("user_id_update")));

        /*if (req.getParameter("submit").equals("update")) {
            //user.setFirstName(req.getParameter("first_name_update"));
            //user.setLastName(req.getParameter("last_name_update"));
            //uhd.update(user);
        } else if (req.getParameter("submit").equals("delete")) {
            //uhd.delete(user);
        } */

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addResults.jsp");

        dispatcher.forward(req, resp);
    }
}
