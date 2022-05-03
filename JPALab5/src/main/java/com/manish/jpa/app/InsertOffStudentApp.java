package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.OfflineStudent;
import com.manish.jpa.app.util.JPAUtil;

public class InsertOffStudentApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			OfflineStudent offstud = new OfflineStudent();
			offstud.setName("Ranjan");
			offstud.setEmail("ranjan@oits.com");
			offstud.setTimings("2.00 PM to 4.00 PM");
			offstud.setBatch("B3");
			offstud.setClassRoom("CLASS-1");
			offstud.setSeat("C1-S1");
			entityManager.persist(offstud);

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
