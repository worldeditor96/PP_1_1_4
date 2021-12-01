package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import javax.transaction.SystemException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, SystemException {

        UserService userServiceImpl=new UserServiceImpl();
        Session session =  Util.getSessionFactory().openSession();

        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Valli", "Kotikov", (byte) 45);
        //userServiceImpl.saveUser("Irina", "Shemeleva", (byte) 25);
        //userServiceImpl.saveUser("Maxim", "Penza", (byte) 543);
        //userServiceImpl.saveUser("Kod", "Jonson", (byte) 34);
        //System.out.println(userServiceImpl.getAllUsers());
        /*


        System.out.println(userServiceImpl.getAllUsers());
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();

         */


    }
}
