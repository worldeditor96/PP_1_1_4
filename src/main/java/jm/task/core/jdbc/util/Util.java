package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {


    //метод в задаче
    private static SessionFactory sessionFactory;

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



