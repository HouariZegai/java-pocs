package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// get the student for delete it
			Student student = session.get(Student.class, studentId);
			
			// delete student
			session.delete(student);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// NEW CODE
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete all student (using HQL)
			session.createQuery("delete Student where id=2")
			.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
