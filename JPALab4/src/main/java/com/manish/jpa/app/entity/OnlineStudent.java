package com.manish.jpa.app.entity;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab4_onstudent")
@PrimaryKeyJoinColumn(name = "sid")
@Data
public class OnlineStudent extends CurrentStudent {
	private String link;
	private String passcode;

	
}
