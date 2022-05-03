package com.manish.jpa.app.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab4_offstudent")
@PrimaryKeyJoinColumn(name = "sid")
@Data
public class OfflineStudent extends CurrentStudent {
	private String classRoom;
	private String seat;

	
}
