package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.JPAUtil;

public class ReadByIdApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		Employee emp = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			emp = entityManager.find(Employee.class, 1);
			if (null != emp) {
				System.out.println("Eid " + emp.getId());
				System.out.println("Name " + emp.getName());
				System.out.println("Email " + emp.getEmail());
				System.out.println("Phone " + emp.getPhone());
				System.out.println("Doj " + emp.getDoj());
			} else {
				System.out.println("No Record Found");
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
