package com.manish.jpa.app.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue(value="OFFSTU")
@Data
public class OfflineStudent extends CurrentStudent {
	private String classRoom;
	private String seat;

	
}
