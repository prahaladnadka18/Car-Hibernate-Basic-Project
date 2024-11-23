package com.jsp.hibernate.demo.Demo_Car;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Car c = new Car();
        
        //Hibernate
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Car.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        
        Car car = session.get(Car.class, 101);
        System.out.println(car.getCarId());
        System.out.println(car.getCarBrand());
        System.out.println(car.getCarModel());
        System.out.println(car.getCarPrice());
        
        tran.commit();
        session.close();
        sf.close();
    
    }
}
