package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;
import org.hibernate.query.Query;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// option 2: Hibernate query with HQL

			// get the instructor from db
			int instructorId = 1;
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses " 
									+ "where i.id=:instructorId",
					Instructor.class);

			// set parameter on query
			query.setParameter("instructorId", instructorId);
			
			// execute the query and get instructor
			Instructor instructor = query.getSingleResult(); 
					
			System.out.println("houari: Instructor: " + instructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			System.out.println("\nHouari: The session in now closed!\n");

			// get courses for the instructor
			System.out.println("houari: Courses: " + instructor.getCourse());

			System.out.println("houari: Done!");
		} finally {
			// clean up code
			session.close();

			factory.close();
		}
	}

}
