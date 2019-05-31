package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;
import com.houarizegai.hibernate.demo.entity.Review;
import com.houarizegai.hibernate.demo.entity.Student;

public class AddCoursesForHouariDemo {

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
			
			// get the student houari from the database
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Loading student: " + student);
			System.out.println("Courses: " + student.getCourses());
			
			// create more courses
			Course course1 = new Course("Software Engineering Course");
			Course course2 = new Course("Security 2600");
			
			// add student to courses
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			System.out.println("Saving the courses ...");
			session.save(course1);
			session.save(course2);
			
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
