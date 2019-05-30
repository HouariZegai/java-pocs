package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;
import com.houarizegai.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Cryptography Course");
			
			// add some reviews
			course.addReview(new Review("Very cool course."));
			course.addReview(new Review("Great course ... love it!"));
			course.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course ... and leverage the cascade all :D
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.save(course);
			
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
