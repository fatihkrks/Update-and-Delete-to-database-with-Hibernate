package com.hibernatedemo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
//			List<City> cities=session.createQuery("from City c where c.countryCode='TUR' OR c.countryCode='USA'").getResultList();
			//from City c where c.countryCode='TUR' AND c.district='Ankara'
			//from City c where c.name LIKE '%kar%'
			//from City c ORDER BY c.name
			//from City c ORDER BY c.name DESC -->AŞAĞIDAN YUKARI Z-A
			
//			for (City city : cities) {
//				System.out.println(city.getName());
//			}
			
			//INSERT
			/*
			 * City city=new City(); city.setName("Düzce 10"); city.setCountryCode("TUR");
			 * city.setDistrict("Karadeniz"); city.setPopulation(100000);
			 * session.save(city);
			 * 
			System.out.println("ŞEHİR EKLENDİ");
			 */
			
			 //UPDATE 
			 City city=session.get(City.class, 4000);
			 city.setName("fatih");
			 session.save(city);
			 System.out.println(city.getName());
			 
			
			/*
			 * DELETE 
			 * City city= session.get(City.class,4000); 
			 * session.delete(city);
			 * 
			 */
			 session.getTransaction().commit();
		} 
		finally {
			factory.close();
		}
	}

}
