package edu.matc.persistence;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * This DAO helps retrieve all information associated with the user table
 * of the database.
 *
 * Created by hentwistle on 9/17/2017.
 */
public class UserHibernateDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all users", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    /** Get a single user for the given username
     *
     * @param userName user's userName
     * @return User
     */
    public User getUser(String userName) {
        User user = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            user = (User) session.get(User.class, userName);
        } catch (HibernateException he) {
            log.error("Error getting user with userName: " + userName, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }


    /** save new user
     * @param user user to insert
     * @return id of the inserted user
     */

    public int insert(User user) {
        int id = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (int) session.save(user);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user: " + user, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    /** save  user
     * @param user user to update
     */

    public void update(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user: " + user, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** save  user
     * @param user user to update
     */

    public void delete(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            session.delete(user);

            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user: " + user, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** Return a list of all users belonging to a given household,
     * based on the household ID
     *
     * @return All users
     */
    public List<User> getAllUsersByHousehold(int householdId) {
        Session session = null;
        List users = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            String sql = "SELECT * FROM user WHERE user_id IN (SELECT user_household.user_id from user_household where household_id = :household_id)";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            query.setParameter("household_id", householdId);
            users = query.list();
        } catch (HibernateException he) {
            log.error("Error getting all housemates with householdId: " + householdId, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

}