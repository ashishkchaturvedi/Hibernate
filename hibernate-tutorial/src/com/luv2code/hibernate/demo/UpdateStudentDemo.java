package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			
			int studentId = 1;
			
			
			//now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			///retrieve the student based on id
			System.out.println("\nGetting student with id: "+ studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Updating Student...");
			myStudent.setFirstName("Ashish");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			
			session.createQuery("Update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		
			
		}finally{
			factory.close();
		}
	}
}
