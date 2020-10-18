package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			//begin the transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("Temp inst Detail" + tempInstructorDetail );
			
			//print the associated instructor
			System.out.println("The associated instructor" + tempInstructorDetail.getInstructor() );
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			//handle connection leak
			session.close();
			
			factory.close();
		}
	}

}
