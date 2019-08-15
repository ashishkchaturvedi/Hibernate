package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

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
			
			//get the pacman course
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			//delete that course
			System.out.println("Deleting the course: "+tempCourse);
			session.delete(tempCourse);
			
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
