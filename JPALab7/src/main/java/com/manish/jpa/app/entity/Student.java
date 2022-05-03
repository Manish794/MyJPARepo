package com.manish.jpa.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab7_student")
@Data
public class Student implements Serializable {
	private static final long serialVersionUID = 4376393278250517713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private int sid;

	@Column(name = "sname")
	private String name;

	@Column(name = "semail")
	private String email;

	@Column(name = "sphone")
	private long phone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")
	private Address address;

}
