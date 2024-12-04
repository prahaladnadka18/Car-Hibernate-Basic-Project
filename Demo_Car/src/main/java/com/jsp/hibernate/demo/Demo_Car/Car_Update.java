package com.jsp.hibernate.demo.Demo_Car;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Update {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Car.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//fetching Details from the DB
		Car car = session.get(Car.class, 101);
		car.setCarBrand("TATA");
		car.setCarModel("BS6");
		
		//Updating the data in DB
		session.update(car);
		
		tran.commit();
		sf.close();
		
		
	}

}
