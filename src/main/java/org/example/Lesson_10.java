package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_10 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Car car = session.get(Car.class, 3);
//            session.delete(car);

            session.createQuery("delete Car where color='green' ").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
