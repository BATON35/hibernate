package com.example.hb02onetoonebi.hibernate.hibernate;

import com.example.hb02onetoonebi.hibernate.Model.Instructor;
import com.example.hb02onetoonebi.hibernate.Model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 1;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);
            System.out.println("\n\n\ntempInstructorDetail:" + tempInstructorDetail);
            System.out.println("the associated instructor: " +
                    tempInstructorDetail.getInstructor() + "\n\n\n");
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
