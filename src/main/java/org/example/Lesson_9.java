package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_9 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Car car = session.get(Car.class, 6);
//            car.setName("Honda");

//            session.createQuery("update Car set price=55000 where year=2022").executeUpdate();

            session.createQuery("update Car set price=88000 where color='Green' ").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }
}
