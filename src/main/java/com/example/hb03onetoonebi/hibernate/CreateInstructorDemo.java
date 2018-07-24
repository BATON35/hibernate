package com.example.hb03onetoonebi.hibernate;



import com.example.hb03onetoonebi.Entity.Course;
import com.example.hb03onetoonebi.Entity.Instructor;
import com.example.hb03onetoonebi.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            Instructor tempInstructor =
//                    new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail(
//                            "http://www.youtube.com",
//                            "Guitar");
//            tempInstructor.setInstructorDetail(tempInstructorDetail);
////            Course curse = new Course("Java from scratch");
////            tempInstructor.add(curse);

            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);
            Course curse = new Course("C from scratch");
            instructor.add(curse);
            session.save(curse);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
