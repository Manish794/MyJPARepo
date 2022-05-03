package com.manish.jpa.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab6_offstudent")
@Data
public class OfflineStudent extends CurrentStudent {
	private String classRoom;
	private String seat;
	
}
