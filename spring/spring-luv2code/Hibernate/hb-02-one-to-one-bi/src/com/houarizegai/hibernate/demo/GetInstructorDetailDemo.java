package com.houarizegai.hibernate.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
            int instructorDetailId = 12;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);

            // print the instructor detail
            System.out.println("Instructor detail: " + instructorDetail);

            // print the associated instructor
            System.out.println("associated Instructor: " + instructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }
    }

}
