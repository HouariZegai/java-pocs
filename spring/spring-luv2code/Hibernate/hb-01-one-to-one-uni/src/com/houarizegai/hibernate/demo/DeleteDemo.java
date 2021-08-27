package com.houarizegai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.houarizegai.hibernate.demo.entity.Instructor;
import com.houarizegai.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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

            // get  instructor by the primary key / id
            int idInstructor = 1;
            Instructor instructor = session.get(Instructor.class, idInstructor);
            System.out.println("Founded instructor: " + instructor);

            // delete the instructors
            if (instructor != null) {
                System.out.println("Deleting: " + idInstructor);

                // Note: we also delete associated "details" object
                // because of CascadeType.ALL
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}
