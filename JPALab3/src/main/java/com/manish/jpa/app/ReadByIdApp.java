package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class ReadByIdApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		Student stu = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			stu = entityManager.find(Student.class, 1);
			if (null != stu) {
				System.out.println("Student Details " + stu.getId() + "\t" + stu.getName());
				System.out.println("Phones " + stu.getPhones());
				System.out.println("Marks " + stu.getMarks());
			} else {
				System.out.println("Not Found");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();
		} finally {
			if (null != entityManager)
				entityManager.close();
		}
		if (stu != null) {
			System.out.println("Emails " + stu.getEmails());
		}
	}
}
