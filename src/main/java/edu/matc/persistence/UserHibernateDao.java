package edu.matc.persistence;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
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

    /** Get a single user for the given id
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


    /** Retrieve users by lastname
     *
     * @param lastName User's last name which is the search criteria
     * @return User
     */
    /*
    public List<User> getUsersByLastName(String lastName) {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("lastName", lastName));
            users = criteria.list();
        } catch (HibernateException he) {
            log.error("Error getting all users with last name: " + lastName, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    } */

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

    /** Return a list of all Households
     *
             * @return All usersByHousehold
     */
    public List<Household> getAllHouseholds() {
        List<Household> households = new ArrayList<Household>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            households = session.createCriteria(Household.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all Households", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return households;
    }

    /** Get a single household for the given id
     *
     * @param id household's id
     * @return Household
     */
    public List<Household> getHouseholdById(int id) {
        Household household = null;
        List<Household> households = new ArrayList<Household>();

        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            household = (Household) session.get(Household.class, id);
            households.add(household);
        } catch (HibernateException he) {
            log.error("Error getting household with id: " + id, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return households;
    }

     public List<User> getUsersByHousehold(int id){
        List<User> users = new ArrayList<User>();
        User user = null;

        log.error("session first");
        Session session = null;
        try {
            log.error("session before " + id);
            session = SessionFactoryProvider.getSessionFactory().openSession();
            log.error("session connected? " + session.isConnected());
            //user = (User) session.get(User.class, id);
            users =  session.createCriteria(User.class)
                    .createAlias("household", "h")
                    .add(Restrictions.eq("h.householdId", id))
                    .list();

            log.error("YOUR UHD ERROR IS " + users.toString());
        } catch (HibernateException he) {
            log.error("Error getting household with id: " + id, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        log.error("Your users are " + users.toString());
        return users;
    }

    /** Get a single user for the given id
     *
     * @param userid user's userid
     * @return User
     */
    public Household getHouseholdByUserId(int userid) {
        Household household = new Household(); //change this
        Session session = null;
        //List results = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            String sql = "SELECT household_id, household_name FROM household WHERE household_id = (SELECT user_household.household_id from user_household where user_id = :user_id)";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Household.class);
            query.setParameter("user_id", userid);
            log.error("household result " + query.uniqueResult().toString());
            log.error(query.getQueryReturns().toString());
            household = (Household) query.uniqueResult();

            //household.setHouseholdName();
            //log.error("household list " + results.toString());
        } catch (HibernateException he) {
            log.error("Error getting household with userid: " + userid, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return household;
    }

    public List<User> getUsersByLastName(String lastName) {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("lastName", lastName));
            users = criteria.list();
        } catch (HibernateException he) {
            log.error("Error getting all users with last name: " + lastName, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    /** Get a single user for the given id
     *
     * @param userName user's userName
     * @return User
     */
    public List getHouseholdByUserName(String userName) {
        Session session = null;
        List results = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            String sql = "SELECT household_id FROM household WHERE household_id = (SELECT user_household.household_id from user_household where user_id = (SELECT user_id FROM user where username = 'hentwistle'))";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            results = query.list();
            log.error("list " + results.toString());
        } catch (HibernateException he) {
            log.error("Error getting household with userName: " + userName, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return results;
    }

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsersByHousehold(int householdId) {
        //User user = new User(); //change this
        Session session = null;
        List users = null;
        log.error("in getAllUsersByHousehold");

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            //household = (Household) session.get(Household.class, userid);
            String sql = "SELECT * FROM user WHERE user_id IN (SELECT user_household.user_id from user_household where household_id = :household_id)";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            query.setParameter("household_id", householdId);
            //query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            users = query.list();
            log.error("household result " + users.toString());
            log.error(users.toString());

            //household.setHouseholdName();
            //log.error("household list " + results.toString());
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