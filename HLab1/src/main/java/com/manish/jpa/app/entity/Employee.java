package com.manish.jpa.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lab1_employee")
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private int id;

	@Column(name = "ename")
	private String name;

	private String email;

	private long phone;

	@Temporal(TemporalType.DATE)
	@Column(name = "joining_date")
	private Date doj;


	public Employee(String name, String email, long phone, Date doj) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doj = doj;
	}


}
