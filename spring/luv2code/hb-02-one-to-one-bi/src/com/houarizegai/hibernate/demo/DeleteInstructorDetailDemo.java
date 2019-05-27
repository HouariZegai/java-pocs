package com.houarizegai.hibernate.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int instructorDetailId = 2;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			
			// now let's delete instructor detail
			System.out.println("Deleting instructor detail: " + instructorDetail);
			session.delete(instructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch(HibernateException he) {
			he.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
