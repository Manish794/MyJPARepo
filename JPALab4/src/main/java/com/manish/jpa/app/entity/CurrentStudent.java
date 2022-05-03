package com.manish.jpa.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab4_cstudent")
@PrimaryKeyJoinColumn(name = "sid")
@Data
public class CurrentStudent extends Student {
	@Column(name = "timing")
	private String timings;
	
	@Column(name = "batch")
	private String batch;

	
}
