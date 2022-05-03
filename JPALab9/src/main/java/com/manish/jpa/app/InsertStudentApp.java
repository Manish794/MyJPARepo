package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Course;
import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class InsertStudentApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Course c1 = entityManager.find(Course.class, 1);
			Course c2 = entityManager.find(Course.class, 2);
			Course c4 = entityManager.find(Course.class, 4);
			Course c5 = entityManager.find(Course.class, 5);

			Student stud = new Student();
			stud.setName("Raj");
			stud.setEmail("raj@oits.com");
			stud.setPhone(9696969696L);
			stud.setCourses(List.of(c1, c4));
			entityManager.persist(stud);

			Student stud2 = new Student();
			stud2.setName("Ranjan");
			stud2.setEmail("ranjan@oits.com");
			stud2.setPhone(9292929292L);
			stud2.setCourses(List.of(c2, c5));
			entityManager.persist(stud2);

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
