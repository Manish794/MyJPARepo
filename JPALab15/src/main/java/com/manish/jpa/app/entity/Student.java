package com.manish.jpa.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@NamedQueries({ @NamedQuery(name = "CityWiseStudent", query = "SELECT st from Student st where st.cty=?1")

})
@Entity
@Table(name = "mystudent")
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private String email;

	@Column(name = "city")
	private String cty;

}
