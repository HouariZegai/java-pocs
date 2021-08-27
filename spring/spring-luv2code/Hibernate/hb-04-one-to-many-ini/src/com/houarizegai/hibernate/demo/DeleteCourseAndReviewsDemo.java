package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Course;
import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;
import com.houarizegai.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

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

            // get the course
            int idCourse = 10;
            Course course = session.get(Course.class, idCourse);

            // print the course
            System.out.println("Course: " + course);

            // print the course reviews
            System.out.println("Reviews: " + course.getReviews());

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
