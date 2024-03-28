package org.example;


import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
//        Car car1 = new Car("Mercedes", 2023, "Red", 150_000, 240.0);
        Car car2 = new Car("BMW", 2020, "White", 175_000, 125.0);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(car2);
        session.getTransaction().commit();
        factory.close();

    }
}