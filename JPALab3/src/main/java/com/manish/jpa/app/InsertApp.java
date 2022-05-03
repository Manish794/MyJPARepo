package com.manish.jpa.app;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
			stud.setEmails(List.of("manish@gmail.com", "mkumar@gmail.com"));
			stud.setPhones(Set.of(88888888L, 99999999L));
			stud.setMarks(Map.of("JPA", 90, "Spring", 87));

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
