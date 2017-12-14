package edu.matc.persistence;

import edu.matc.entity.Household;
import edu.matc.entity.Task;
import edu.matc.entity.User;
import edu.matc.entity.Week;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This DAO helps retrieve all information associated with the week table
 * of the database.
 *
 * Created by hentwistle on 9/17/2017.
 */
public class WeekHibernateDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all weeks
     *
     * @return All weeks
     */
    public List<Week> getAllWeeks() {
        List<Week> weeks = new ArrayList<Week>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            weeks = session.createCriteria(Week.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all weeks", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return weeks;
    }

    /** Get a single week for the given id
     *
     * @param id week's id
     * @return week
     */
    public Week getWeekById(int id) {
        Week week = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            week = (Week) session.get(Week.class, id);
        } catch (HibernateException he) {
            log.error("Error getting week with id: " + id, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return week;
    }
}