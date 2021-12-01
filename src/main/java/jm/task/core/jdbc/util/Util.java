package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {

    private static final String Url = "jdbc:mysql://localhost/";
    private static final String Username = "Max";
    private static final String Password = "1111";
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;



    public static SessionFactory getSessionFactory() {
 try {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, Driver);
        settings.put(Environment.URL, Url);
        settings.put(Environment.USER, Username);
        settings.put(Environment.PASS, Password);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        sessionFactory = new Configuration().setProperties(settings).addAnnotatedClass(User.class).buildSessionFactory();
    } catch (Exception exception) {
        throw new ExceptionInInitializerError();

    } return sessionFactory;
}

    /*
    public static SessionFactory getSessionFactory() {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
            //sessionFactory = new Configuration().buildSessionFactory();
            //return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("SessionFactory creation failed");
            throw new ExceptionInInitializerError(e);
        }
        return sessionFactory;
    }

     */



    //методы из примера задаче
    /*
        public static SessionFactory getSessionFactory () {
            return sessionFactory;
        }



        public static void shutdown () {
            getSessionFactory().close();
        }

        //метод в задаче

    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession() {
        return (Session) getSessionFactory().openSession();
    }

    //
    public Session openTransactionSession() {
        session = openSession();
        //transaction = session.beginTransaction();
        return session;
    }

    public void clodseSession() throws JMSException {
        session.close();
    }

    public void closeTransactionSession() throws JMSException {
        transaction.commit();
        clodseSession();
    }

     */

}



