package one_to_one;

import one_to_one.entity.Car;
import one_to_one.entity.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Engine.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Car car1 = new Car("Volvo", 2020, "Black", 2000, 135.7);
//            Engine engine1 = new Engine(500, 2000);
//            car1.setCarEngine(engine1);

            Car car1 = new Car("BMW", 2022, "White", 3000, 248.0);
            Engine engine1 = new Engine(450, 1750);
            car1.setCarEngine(engine1);

            session.save(car1);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }
}
