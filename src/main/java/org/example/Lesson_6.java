package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Car car1 = session.get(Car.class, 2);

            System.out.println(car1);
            car1.setSpeed(111.1);
            System.out.println(car1);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
