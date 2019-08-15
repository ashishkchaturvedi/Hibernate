package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			
			int studentId = 3;
			
			
			//now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			///retrieve the student based on id
			System.out.println("\nGetting student with id: "+ studentId);
			
			//Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Delete Student...");
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		
			
		}finally{
			factory.close();
		}
	}
}
