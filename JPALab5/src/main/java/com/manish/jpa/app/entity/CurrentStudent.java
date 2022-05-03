package com.manish.jpa.app.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue(value="CSTU")
@Data
public class CurrentStudent extends Student {
	@Column(name = "timing")
	private String timings;
	
	@Column(name = "batch")
	private String batch;

	
}
