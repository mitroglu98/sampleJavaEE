package me.fit.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone implements Serializable{

	private static final long serialVersionUID = -6259826457388313121L;

	@Id
	private Long id;
	
	private String number;
	
	@ManyToOne
	private Student student;

	public Phone() {
		super();
	}
	
}
