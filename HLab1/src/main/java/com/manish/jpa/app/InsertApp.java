package com.manish.jpa.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.HibernateUtil;

public class InsertApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Employee emp = new Employee("Manish", "manish@gmail.com", 74856985, new Date());
			System.out.println("Before save " + emp.getId());
			session.save(emp);
			System.out.println("After save " + emp.getId());
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
