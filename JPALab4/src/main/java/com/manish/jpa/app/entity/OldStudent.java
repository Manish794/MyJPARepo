package com.manish.jpa.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab4_ostudent")
@PrimaryKeyJoinColumn(name = "sid")
@Data
public class OldStudent extends Student {
	@Column(name = "sessionYear")
	private int sessionYear;
	@Column(name = "cname")
	private String companyName;

}
