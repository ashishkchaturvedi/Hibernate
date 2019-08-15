package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			System.out.println("luv2Code: Instructor: "+tempInstructor);

			//get course for the instructor
			System.out.println("luv2code: courses: "+tempInstructor.getCourse());
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the Session
			session.close();
			
			System.out.println("\nluv2Code: The session is closed!\n");
			//call getter method when session is open
			
			//get course for the instructor
			System.out.println("luv2code: courses: "+tempInstructor.getCourse());
			
			System.out.println("Done!");
			 
		}finally{
			
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}
