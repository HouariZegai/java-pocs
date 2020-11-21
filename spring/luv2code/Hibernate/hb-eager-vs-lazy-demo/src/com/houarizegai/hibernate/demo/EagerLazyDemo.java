package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int idInstructor = 1;
            Instructor instructor = session.get(Instructor.class, idInstructor);

            System.out.println("houari: Instructor: " + instructor);

            // option 1: call getter method while session is open 
            // get courses for the instructor
            System.out.println("houari: Courses: " + instructor.getCourse()); // demand the course before close the session (work fine)

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nHouari: The session in now closed!\n");

            // since course are lazy loaded ... this should fail
            // update: because i call the getter method above before close the session, i solve the issue of lazy fetch :D

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
