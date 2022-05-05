package com.manish.jpa.app.service;

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

public class StudentService {
	
	public Student addStudent(Student st) {
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			eManager.persist(st);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return st;
	}

	public Student getStudentById(int sid) {
		Student st = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			st = eManager.find(Student.class, sid);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return st;
	}

	public Student updateStudent(Student newData) {
		Student st = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			st = eManager.find(Student.class, newData.getSid());
			if (st != null) {
				st.setSname(newData.getSname());
				st.setEmail(newData.getEmail());
				st.setCty(newData.getCty());
				eManager.merge(st);				
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return st;
	}
	
	public boolean deleteById(int sid) {
		boolean deleted = false;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			Student st = eManager.find(Student.class, sid);
			if (st != null) {
				eManager.remove(st);
				deleted = true;
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return deleted;
	}

	public List<Student> getAllStudents() {
		List<Student> students = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			
			CriteriaBuilder builder = eManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root);
			
			Query q = eManager.createQuery(criteriaQuery);
			students = q.getResultList();
						
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return students;
	}
	
	
	public List<Student> getStudentByCity(String city) {
		List<Student> students = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			
			CriteriaBuilder builder = eManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root);
			
			Predicate pr1 = builder.equal(root.get("cty"), city);
			criteriaQuery.where(pr1);
			
			Query q = eManager.createQuery(criteriaQuery);
			students = q.getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return students;
	}
	
	public List<Student> getStudentByName(String name) {
		List<Student> students = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			
			CriteriaBuilder builder = eManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root);
			
			Predicate pr1 = builder.equal(root.get("sname"), name);
			criteriaQuery.where(pr1);
			
			Query q = eManager.createQuery(criteriaQuery);
			students = q.getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return students;
	}
	
	
	public List<Student> getStudentByNameWithLike(String name) {
		List<Student> students = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			
			CriteriaBuilder builder = eManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root);
			
			Predicate pr1 = builder.like(root.get("sname"), "%"+name+"%");
			criteriaQuery.where(pr1);
			
			Query q = eManager.createQuery(criteriaQuery);
			students = q.getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return students;
	}
	
	public List<Student> getStudentByNameStarts(String name) {
		List<Student> students = null;
		EntityManager eManager = null;
		EntityTransaction transaction = null;
		try {
			eManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			transaction = eManager.getTransaction();
			transaction.begin();
			
			CriteriaBuilder builder = eManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root);
			
			Predicate pr1 = builder.like(root.get("sname"), name+"%");
			criteriaQuery.where(pr1);
			
			Query q = eManager.createQuery(criteriaQuery);
			students = q.getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (eManager != null) {
				eManager.close();
			}
		}
		return students;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
