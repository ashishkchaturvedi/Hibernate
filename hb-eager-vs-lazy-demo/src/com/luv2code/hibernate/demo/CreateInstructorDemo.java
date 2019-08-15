package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			///create the object
			Instructor tempInstructor =
		new Instructor("Shicha","Chaturvedi","shicha@lluv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.youtube.com",
							"Reader");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Start a transaction
			session.beginTransaction();
			
			//save the instructor
			
			//this will also save the details object
			//because of cascadeType.ALL
			System.out.println("Saving Instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			
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
