package com.manish.jpa.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeId implements Serializable {
	private int eid;
	private String branchId;

	public EmployeeId(String branchId) {
		this.branchId = branchId;
	}

}
