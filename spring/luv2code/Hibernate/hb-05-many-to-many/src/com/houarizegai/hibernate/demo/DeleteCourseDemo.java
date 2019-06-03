package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;
import com.houarizegai.hibernate.demo.entity.Review;
import com.houarizegai.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course u wanna delete it from database
			int courseId = 12;
			Course course = session.get(Course.class, courseId);
			
			// delete the course
			System.out.println("Deleting the course ...");
			
			session.delete(course);
			
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
