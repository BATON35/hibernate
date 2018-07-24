package com.example.hb03onetoonebi.hibernate;



import com.example.hb03onetoonebi.Entity.Course;
import com.example.hb03onetoonebi.Entity.Instructor;
import com.example.hb03onetoonebi.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
            Instructor tempInstructor =
                    new Instructor("Madhu", "Patel", "madhu@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "Guitar");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
//            Course curse = new Course("Java from scratch");
//            tempInstructor.add(curse);

            session.beginTransaction();
          //  System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);
            session.getTransaction().commit();
           // System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
