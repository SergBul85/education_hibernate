package one_to_many_1;

import one_to_many_1.entity.*;
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
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Owner owner = new Owner("Vasia", 25);
//            Car car1 = new Car("Siat", 170);
//            Car car2 = new Car("Fiat", 180);
//            owner.addCarToOwner(car1);
//            owner.addCarToOwner(car2);
//            session.save(owner);
//            Car car3 = new Car("ZAZ", 777);
//            session.save(car3);

//            Car car = session.get(Car.class,7);
//            session.delete(car);

            var owner = session.get(Owner.class, 7);
            session.delete(owner);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
