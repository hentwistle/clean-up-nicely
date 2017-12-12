package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This DAO helps retrieve all information associated with the user_role table
 * of the database.
 *
 * Created by hentwistle on 12/11/2017.
 */
public class UserRoleHibernateDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all user_roles
     *
     * @return All user roles
     */
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<UserRole>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            userRoles = session.createCriteria(UserRole.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all user roles", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userRoles;
    }

    /** Get a single user role for the given username
     *
     * @param userName user role's userName
     * @return UserRole
     */
    public UserRole getUserRole(String userName) {
        UserRole userRole = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            userRole = (UserRole) session.get(UserRole.class, userName);
        } catch (HibernateException he) {
            log.error("Error getting user role with userName: " + userName, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userRole;
    }


    /** save new user role
     * @param user role user role to insert
     * @return id of the inserted user
     */

    public int insert(UserRole userRole) {
        int userRoleId = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            userRoleId = (int) session.save(userRole);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user role: " + userRoleId, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userRoleId;
    }

    /** save  userRole
     * @param userRole userRole to update
     */

    public void update(UserRole userRole) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(userRole);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of userRole: " + userRole, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /** delete userRole
     * @param userRole userRole to update
     */

    public void delete(UserRole userRole) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(userRole);
            session.delete(userRole);

            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user role: " + userRole, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}