package com.manish.jpa.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab7_address")
@Data
public class Address implements Serializable {
	private static final long serialVersionUID = 4376393278250517713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private int aid;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "pin")
	private int pin;

	@OneToOne(mappedBy = "address")
	private Student student;

}
