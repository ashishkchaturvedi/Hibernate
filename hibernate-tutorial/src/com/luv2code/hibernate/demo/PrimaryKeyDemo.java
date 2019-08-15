package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					//create 3 student object
					System.out.println("Creating 3 student object...");
					Student tempStudent1 = new Student("Shicha","Chaturvedi","shicha@luv2code.com");
					Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
					Student tempStudent3 = new Student("Bonita","Applebum","Bonita@luv2code.com");
					
					//Start a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student objects...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
					
				}finally{
					factory.close();
				}


	}

}