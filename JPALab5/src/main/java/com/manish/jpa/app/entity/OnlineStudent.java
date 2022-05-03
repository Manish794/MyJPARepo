package com.manish.jpa.app.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue(value="ONSTU")
@Data
public class OnlineStudent extends CurrentStudent {
	private String link;
	private String passcode;

	
}
