package one_to_many;

import one_to_many.entity.Car;
import one_to_many.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();
        Session session = null;

        Owner owner1 = new Owner("Ivan", 25);
        Car car1 = new Car("AUDI", 111);
        Car car2 = new Car("BMW", 222);

        owner1.addCarToOwner(car1);
        owner1.addCarToOwner(car2);

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(owner1);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
