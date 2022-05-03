package com.manish.jpa.app.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lab6_onstudent")
@Data
public class OnlineStudent extends CurrentStudent {
	private String link;
	private String passcode;

	
}
