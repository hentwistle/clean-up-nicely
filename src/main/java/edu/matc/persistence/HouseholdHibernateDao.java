package edu.matc.persistence;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * This DAO helps retrieve all information associated with the household table
 * of the database.
 *
 * Created by hentwistle on 9/17/2017.
 */
public class HouseholdHibernateDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all households
     *
     * @return All households
     */
    public List<Household> getAllHouseholds() {
        List<Household> households = new ArrayList<Household>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            households = session.createCriteria(Household.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all households", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return households;
    }

    /** Get a single household for the given id
     *
     * @param householdId household's id
     * @return Household
     */
    public Household getHousehold(int householdId) {
        Household household = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            household = (Household) session.get(Household.class, householdId);
        } catch (HibernateException he) {
            log.error("Error getting household with Id: " + householdId, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return household;
    }

    /** save new household
     * @param household household to insert
     * @return id of the inserted household
     */

    public int insert(Household household) {
        int id = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (int) session.save(household);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of household: " + household, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    /** Get a single user for the given id
     *
     * @param userid user's userid
     * @return User
     */
    public Household getHouseholdByUserId(int userid) {
        Household household = new Household(); //change this
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            String sql = "SELECT household_id, household_name FROM household WHERE household_id = (SELECT user_household.household_id from user_household where user_id = :user_id)";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Household.class);
            query.setParameter("user_id", userid);
            log.error("household result " + query.uniqueResult().toString());
            log.error(query.getQueryReturns().toString());
            household = (Household) query.uniqueResult();
        } catch (HibernateException he) {
            log.error("Error getting household with userid: " + userid, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return household;
    }
}