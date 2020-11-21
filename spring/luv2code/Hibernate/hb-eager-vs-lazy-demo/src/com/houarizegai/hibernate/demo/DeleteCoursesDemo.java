package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

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

            // get the course from the db
            int idCourse = 10;
            Course course = session.get(Course.class, idCourse);
            System.out.println("Deleting course: " + course);

            // delete the course 
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
