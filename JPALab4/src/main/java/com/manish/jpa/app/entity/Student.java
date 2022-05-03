package com.manish.jpa.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab4_student")
@Inheritance(strategy =  InheritanceType.JOINED)
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


}
