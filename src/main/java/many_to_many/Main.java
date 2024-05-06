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

//            Passeger passeger1 = session.get(Passeger.class,4);
//            System.out.println(passeger1);
//            System.out.println(passeger1.getTaxiList());

//****************************************** - LESSON 33 ************************

//            Taxi taxi3 = new Taxi();
//            taxi3.setName("AUDI");
//            Passeger passeger3 = session.get(Passeger.class, 3);
//            Passeger passeger4 = session.get(Passeger.class, 4);
//
//            taxi3.addPassegerToTaxi(passeger3);
//            taxi3.addPassegerToTaxi(passeger4);
//            session.save(taxi3);

//            Passeger passeger3 = session.get(Passeger.class, 3);
//            session.delete(passeger3);

//****************************************** - LESSON 34 ************************

            Taxi taxi1 = new Taxi("Mazda");
            Taxi taxi2 = new Taxi("FORD");
            Taxi taxi3 = new Taxi("BMW");

            session.save(taxi1);
            session.save(taxi2);
            session.save(taxi3);

            Passeger passeger1 = new Passeger("Vasia", 32);
            Passeger passeger2 = new Passeger("Olia", 23);
            Passeger passeger3 = new Passeger("Kolia", 45);
            Passeger passeger4 = new Passeger("Tania", 45);
            Passeger passeger5 = new Passeger("SERG", 45);

            session.save(passeger1);
            session.save(passeger2);
            session.save(passeger3);
            session.save(passeger4);
            session.save(passeger5);

            taxi1.addPassegerToTaxi(passeger1);
            taxi1.addPassegerToTaxi(passeger2);
            taxi1.addPassegerToTaxi(passeger3);

            taxi2.addPassegerToTaxi(passeger2);
            taxi2.addPassegerToTaxi(passeger3);
            taxi2.addPassegerToTaxi(passeger4);

            taxi3.addPassegerToTaxi(passeger3);
            taxi3.addPassegerToTaxi(passeger4);
            taxi3.addPassegerToTaxi(passeger5);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
