package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			
			//Start a transaction
			session.beginTransaction();
			
			//query Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display Students
			displayStudents(theStudents);
			
			//query Students:
			theStudents= session.createQuery("from Student s where s.lastName='Chaturvedi'").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who have last name as Chaturvedi");
			displayStudents(theStudents);
			
			//query Students: last name as Chaturvedi and first name daffy
			theStudents = session.createQuery("from Student s where"
					+" s.lastName ='Chaturvedi' OR s.firstName='Daffy'").getResultList();
			
			//display Students
			System.out.println("\n\nStudents with lastname Chaturvedi OR firstname daffy ");
			displayStudents(theStudents);
		
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
