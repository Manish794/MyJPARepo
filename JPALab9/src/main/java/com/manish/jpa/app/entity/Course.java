package com.manish.jpa.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab9_course")
@Data
public class Course implements Serializable {
	private static final long serialVersionUID = 4376393278250517713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private int cid;

	@Column(name = "name")
	private String name;

	@Column(name = "fee")
	private float fee;

	@Column(name = "duration")
	private String duration;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

}
