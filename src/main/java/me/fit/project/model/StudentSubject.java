package me.fit.project.model;

import javax.persistence.ManyToOne;

public class StudentSubject {

	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Subject subject;
	
	
}
