package me.fit.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class StudentSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentsubject_seq")
	@SequenceGenerator(name = "studentsubject_seq", sequenceName = "studentsubject_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Subject subject;
	
	
}
