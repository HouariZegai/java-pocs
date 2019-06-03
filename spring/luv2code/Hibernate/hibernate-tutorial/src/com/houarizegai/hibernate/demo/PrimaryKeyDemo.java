package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		// create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			
			// create session
			Session session = factory.getCurrentSession();
			
			try {
				System.out.println("Creating 3 new student object...");
				// create 3 student object
				Student student1 = new Student("Houari", "ZEGAI", "houarizegai14@gmail.com");
				Student student2 = new Student("Mohamed", "Khaled", "mohamed@houarizegai.com");
				Student student3 = new Student("Omar", "Farouk", "omar@houarizegai.com");
				
				// start a transaction
				session.beginTransaction();
				
				// save the student object
				System.out.println("Saving the students...");
				session.save(student1);
				session.save(student2);
				session.save(student3);
				
				// commit transaction
				session.getTransaction().commit();
				
				System.out.println("Done!");
			} finally {
				factory.close();
			}
	}
}
