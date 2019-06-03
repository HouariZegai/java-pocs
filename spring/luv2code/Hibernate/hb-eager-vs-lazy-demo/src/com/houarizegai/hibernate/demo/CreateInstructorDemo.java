package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor instructor = new Instructor("Mohamed", "Omar", "omar@houarizegai.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/ZegaiOmar", "Video Games");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			// clean up code
			session.close();
			
			factory.close();
		}
	}

}
