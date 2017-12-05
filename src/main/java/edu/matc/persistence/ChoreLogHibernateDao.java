package edu.matc.persistence;

import edu.matc.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * This DAO helps retrieve all information associated with the chore_log_by_user table
 * of the database.
 *
 * Created by hentwistle on 9/17/2017.
 */
public class ChoreLogHibernateDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all chore logs
     *
     * @return All chore logs
     */
    public List<ChoreLogByUser> getAllChoreLogs() {
        List<ChoreLogByUser> choreLogs = new ArrayList<ChoreLogByUser>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            choreLogs = session.createCriteria(ChoreLogByUser.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all chore logs", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return choreLogs;
    }


    /** Get a single chore log for the given id
     *
     * @param userId user's id
     * @param weekId the week's id
     *
     * @return ChoreLogByUser
     */
    public List getChoreLogEntry(int userId, int weekId) {
        List<ChoreLogByUser> logs = new ArrayList<ChoreLogByUser>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ChoreLogByUser.class);
            criteria.add(Restrictions.eq("userId", userId));
            criteria.add(Restrictions.eq("weekId", weekId));
            logs = criteria.list();
        } catch (HibernateException he) {
            log.error("Error getting chore log entry with userId: " + userId + " and weekId: " + weekId, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return logs;
    }

    public List getAllLogsByUser(int userId) {
        List<ChoreLogByUser> logs = new ArrayList<ChoreLogByUser>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ChoreLogByUser.class);
            criteria.add(Restrictions.eq("userId", userId));
            logs = criteria.list();
        } catch (HibernateException he) {
            log.error("Error getting all chore log entries with userId: " + userId, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return logs;
    }

    /** Get a single chore log for the given id
     *
     * @param userId user's id
     * @param weekId the week's id
     *
     * @return ChoreLogByUser
     */
    public ChoreLogByUser getTime(int userId, int weekId, int taskId) {
        ChoreLogByUser choreLogByUser = new ChoreLogByUser();

        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ChoreLogByUser.class);
            criteria.add(Restrictions.eq("userId", userId));
            criteria.add(Restrictions.eq("weekId", weekId));
            criteria.add(Restrictions.eq("taskId", taskId));
            choreLogByUser = (ChoreLogByUser) criteria.uniqueResult();
        } catch (HibernateException he) {
            log.error("Error getting chore log entry with userId: " + userId + " and weekId: " + weekId, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return choreLogByUser;
    }
    /** save new choreLogByUser
     * @param choreLogByUser the choreLogByUser to insert
     * @return id of the inserted household
     */

    public int insert(ChoreLogByUser choreLogByUser) {
        int id = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            choreLogByUser = (ChoreLogByUser) session.save(choreLogByUser);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of choreLogByUser with UserId: " + choreLogByUser.getUserId(), he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    /** save  choreLogByUser
     * @param choreLogByUser choreLogByUser to update
     */

    public void update(ChoreLogByUser choreLogByUser) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(choreLogByUser);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of choreLogByUser: " + choreLogByUser, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}