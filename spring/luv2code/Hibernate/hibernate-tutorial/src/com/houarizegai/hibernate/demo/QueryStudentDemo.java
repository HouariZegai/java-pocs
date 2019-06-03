package com.houarizegai.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			// query the students (HQL Language: use class name & attribute name in java, don't use names in database)
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// display the students
			System.out.println("Display all the student ...");
			displayStudent(students);
			
			// query student: lastName='ZEGAI' OR firstName='Houari'
			students = session.createQuery("from Student s where s.lastName='ZEGAI' OR s.firstName='Houari'").getResultList();
			
			// display the students
			System.out.println("Display query the student (lastName='ZEGAI' OR firstName='Houari') ...");
			displayStudent(students);
	
			// query student: email end with '@houarizegai.com'
			students = session.createQuery("from Student s where s.email LIKE '%@houarizegai.com'").getResultList();
			
			// display the students
			System.out.println("Display query the student (email LIKE '@houarizegai.com')...");
			displayStudent(students);
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
	
	private static void displayStudent(List<Student> students) {
		for(Student student : students)
			System.out.println(student);
	}

}
