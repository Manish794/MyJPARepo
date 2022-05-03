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

			Address add = new Address();
			add.setCity("Blore");
			add.setStreet("BTM Layout");
			add.setPin(457854);
			entityManager.persist(add);

			Student stud = new Student();
			stud.setName("Manish");
			stud.setEmail("manish@oits.com");
			stud.setPhone(9696969696L);
			stud.setAddress(add);
			entityManager.persist(stud);

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
