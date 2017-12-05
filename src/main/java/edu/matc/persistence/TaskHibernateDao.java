package edu.matc.persistence;

import edu.matc.entity.Household;
import edu.matc.entity.Task;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * This DAO helps retrieve all information associated with the task table
 * of the database.
 *
 * Created by hentwistle on 9/17/2017.
 */
public class TaskHibernateDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<Task>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            tasks = session.createCriteria(Task.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all tasks", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tasks;
    }

    /** Get a single user for the given id
     *
     * @param id user's id
     * @return User
     */
    public Task getTask(int id) {
        Task task = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            task = (Task) session.get(Task.class, id);
        } catch (HibernateException he) {
            log.error("Error getting user with id: " + id, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return task;
    }
}