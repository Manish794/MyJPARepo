package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Address;
import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class InsertApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Student stud = new Student();
			stud.setName("Manish");
			stud.setEmail("Manish@oits.com");
			stud.setPhone(9696969696L);
			entityManager.persist(stud);

			Address add1 = new Address();
			add1.setCity("BLR");
			add1.setStreet("HSR Layout");
			add1.setPin(562255);
			add1.setStudent(stud);
			entityManager.persist(add1);

			Address add2 = new Address();
			add2.setCity("DEL");
			add2.setStreet("Southx");
			add2.setPin(562255);
			add2.setStudent(stud);
			
			entityManager.persist(add2);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();
		} finally {
			if (null != entityManager)
				entityManager.close();
		}
	}
}
