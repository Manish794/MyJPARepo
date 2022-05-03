package com.manish.jpa.app.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue(value="OSTU")
@Data
public class OldStudent extends Student {
	@Column(name = "sessionYear")
	private int sessionYear;
	@Column(name = "cname")
	private String companyName;

}
