package com.manish.jpa.app.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lab3_student")
@Data
@NoArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 2757964748851714820L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private int id;

	@Column(name = "sname")
	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "lab3_emails", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "semail")
	private List<String> emails;

	@ElementCollection
	@CollectionTable(name = "lab3_phones", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "sphone")
	private Set<Long> phones;

	@ElementCollection
	@CollectionTable(name = "lab3_marks", joinColumns = @JoinColumn(name = "sid"))
	@MapKeyColumn(name = "subject")
	@Column(name = "markObtained")
	private Map<String, Integer> marks;

}
