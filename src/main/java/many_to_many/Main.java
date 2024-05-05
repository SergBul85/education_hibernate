package many_to_many;

import many_to_many.entity.Passeger;
import many_to_many.entity.Taxi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passeger.class)
                .addAnnotatedClass(Taxi.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Taxi taxi1 = new Taxi();
//            taxi1.setName("Mazda");
//
//            Passeger passeger1 = new Passeger("Vasia", 32);
//            Passeger passeger2 = new Passeger("Olia", 23);
//            Passeger passeger3 = new Passeger("Kolia", 45);
//            taxi1.addPassegerToTaxi(passeger1);
//            taxi1.addPassegerToTaxi(passeger2);
//            taxi1.addPassegerToTaxi(passeger3);
//            session.save(taxi1);
//            Taxi taxi2 = new Taxi("BMW");//
//            taxi2.addPassegerToTaxi(passeger2);
//            taxi2.addPassegerToTaxi(passeger3);
//
//            session.save(taxi2);

//****************************************** - LESSON 32 ************************


//            Taxi taxi1= session.get(Taxi.class,1);
//            System.out.println(taxi1);
//            System.out.println(taxi1.getPassegerList());

            Passeger passeger1 = session.get(Passeger.class,4);
            System.out.println(passeger1);
            System.out.println(passeger1.getTaxiList());


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
