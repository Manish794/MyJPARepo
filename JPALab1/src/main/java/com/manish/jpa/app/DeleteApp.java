package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.JPAUtil;

public class DeleteApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Employee emp = entityManager.find(Employee.class, 1);
			if (null != emp) {
				entityManager.remove(emp);
			} else {
				System.out.println("Data not found to Delete");
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
