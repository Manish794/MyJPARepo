package com.manish.jpa.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.util.HibernateUtil;

public class DeleteApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			Employee emp = session.find(Employee.class, 1);
			if (null != emp) {
				session.delete(emp);
			} else {
				System.out.println("Data not found to Delete");
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
