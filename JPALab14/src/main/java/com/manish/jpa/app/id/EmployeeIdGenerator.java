package com.manish.jpa.app.id;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.entity.EmployeeId;

public class EmployeeIdGenerator implements IdentifierGenerator {
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Employee employee = (Employee) object;
		EmployeeId empId = employee.getEmployeeId();
		if (empId == null || empId.getBranchId() == null || empId.getBranchId().trim().length() == 0) {
			throw new IllegalArgumentException("Branch is required");
		}
		String branch = empId.getBranchId();
		Query query = session
				.createQuery("SELECT max(em.employeeId.eid) from Employee em where em.employeeId.branchId=?1");
		query.setParameter(1, branch);
		List list = query.getResultList();
		if (list == null || list.size() == 0 || list.get(0) == null)
			return new EmployeeId(1, branch);

		int maxId = (Integer) list.get(0);
		maxId++;
		return new EmployeeId(maxId, branch);
	}
}
