package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo2 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			
			//Start a transaction
			session.beginTransaction();
			
			//get student mary from database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\nLLoaded student: "+tempStudent);
			System.out.println("Courses "+tempStudent.getCourse());
			
			//delete student
			System.out.println("\nDeleting student: "+tempStudent);
			session.delete(tempStudent);
			
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
