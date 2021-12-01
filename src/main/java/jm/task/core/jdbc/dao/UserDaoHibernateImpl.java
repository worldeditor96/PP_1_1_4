package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.transaction.SystemException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    public void createUsersTable() throws SQLException {
        //Все методы начинаются с того, что мы открываем сессию с трпнзакцией
        Transaction transaction = null;
        Session session = null;

        // auto close session object
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS User (id MEDIUMINT NOT NULL AUTO_INCREMENT, name VARCHAR (30) NOT NULL, lastName VARCHAR (30) NOT NULL, age MEDIUMINT, PRIMARY KEY (id));").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void dropUsersTable() throws SQLException {
        //Все методы начинаются с того, что мы открываем сессию с трпнзакцией
        Transaction transaction = null;
        Session session = null;

        // auto close session object
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    // возможно готово
    public void saveUser(String name, String lastName, byte age) throws SQLException, SystemException {
        //Все методы начинаются с того, что мы открываем сессию с трпнзакцией
        Transaction transaction = null;
        Session session = null;


        try {
            session = sessionFactory.openSession();


            transaction = session.beginTransaction();

            session.save(name);
            session.save(lastName);
            session.save(age);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

// возможно готово
    public void removeUserById(long id) {
        Transaction transaction = null;
        Session session = null;


        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            transaction.begin();


                session.remove(id);
                System.out.println(" is removed");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;


        try {
            session = Util.getSessionFactory().openSession();


            transaction = session.beginTransaction();
            transaction.begin();

            User user = new User();
            /*String hql = "insert into User (user.setId, user.name, lastName, ) " +
                    "select 'id', 'name' from User";*/
            String hql = "FROM User";
            Query query = session.createQuery(hql);
            users = query.list();



            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return users;
    }

    public void cleanUsersTable() throws SQLException {

    }
}
