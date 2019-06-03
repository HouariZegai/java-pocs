package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			int studentId = 1;
			
			// get the student for update it
			Student student = session.get(Student.class, studentId);
			
			// updating student...
			student.setFirstName("Fares");
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// NEW CODE
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// upadate all student (using HQL)
			session.createQuery("update Student set email='foo@gmail.com' where email LIKE '%@houarizegai.com'")
			.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
