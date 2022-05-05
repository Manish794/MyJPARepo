package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;


public class ReadAllWithQBCApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root);
			
			Query q = entityManager.createQuery(criteriaQuery);
			List list = q.getResultList();

			if (list == null || list.size() == 0) {
				System.out.println("Not Found");
			} else {
				List<Student> studList = (List<Student>) list;
				for (Student st : studList) {
					System.out.println(st.getSid() + "\t" + st.getSname() + "\t" + st.getEmail() + "\t" + st.getCty());
				}
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
	}
}
