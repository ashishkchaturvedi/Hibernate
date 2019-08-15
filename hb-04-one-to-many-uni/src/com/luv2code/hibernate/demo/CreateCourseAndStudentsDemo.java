package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one million points");
			
			System.out.println("\nsaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: "+tempCourse);
			
			//create the students
			Student tempStudent = new Student("John","Doe","john@luv2code.com");
			Student tempStudent2 = new Student("Mary","public","mary@luv2code.com");
			//Student tempStudent3 = new Student("John","Doe","john@luv2code.com");
			
			//add students
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent2);
			
			//saving the students
			System.out.println("\nSaving students...");
			session.save(tempStudent);
			session.save(tempStudent2);
			//System.out.println("Saved students: "+tempStudent+tempStudent2);

			
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
