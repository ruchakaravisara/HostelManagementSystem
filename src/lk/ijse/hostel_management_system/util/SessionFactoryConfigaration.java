package lk.ijse.hostel_management_system.util;

import lk.ijse.hostel_management_system.entity.Reservation;
import lk.ijse.hostel_management_system.entity.Room;
import lk.ijse.hostel_management_system.entity.Student;
import lk.ijse.hostel_management_system.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfigaration {
    private static SessionFactoryConfigaration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfigaration(){

        sessionFactory = new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfigaration getInstance() {
        return (null == factoryConfiguration) ?
                factoryConfiguration = new SessionFactoryConfigaration() : factoryConfiguration;
    }

    public Session getSession() throws HibernateException {

        Session session = sessionFactory.openSession();

        return session;
    }
}
