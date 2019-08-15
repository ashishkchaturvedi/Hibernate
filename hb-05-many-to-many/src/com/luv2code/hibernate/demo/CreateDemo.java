package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			//CREATE THE OBJECTS
			/*Instructor tempInstructor = 
					new Instructor("Ashish","Chaturvedi","ashish@lluv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.luv2code.co/youtube",
							"Luv 2 Code!!!");
			*/
			Instructor tempInstructor =
		new Instructor("Shicha","Chaturvedi","shicha@lluv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.youtube.com",
							"Guitar");
			
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
			factory.close();
		}
	}

}
