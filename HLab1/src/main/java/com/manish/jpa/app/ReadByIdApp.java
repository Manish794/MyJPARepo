package com.manish.jpa.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.HibernateUtil;

public class ReadByIdApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Employee emp = session.find(Employee.class, 2);
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
			if (null != session)
				session.close();
			HibernateUtil.shutdown();
		}

	}
}
