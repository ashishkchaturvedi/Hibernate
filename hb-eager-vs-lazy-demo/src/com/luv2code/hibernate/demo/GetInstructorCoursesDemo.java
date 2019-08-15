package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			
			//Start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theID = 1;
			Instructor tempInstructor = session.get(Instructor.class, theID);
			
			//get
			System.out.println("Instructor: "+tempInstructor);
			
			//get course for the instrutor
			System.out.println("courses: "+tempInstructor.getCourse());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			 
		}finally{
			
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}
