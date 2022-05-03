package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.OldStudent;
import com.manish.jpa.app.util.JPAUtil;

public class InsertOStudentApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			OldStudent ostud = new OldStudent();
			ostud.setName("Manish");
			ostud.setEmail("Manish@oits.com");
			ostud.setSessionYear(2019);
			ostud.setCompanyName("OITS");
			entityManager.persist(ostud);

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
