package me.fit.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Phone implements Serializable{

	private static final long serialVersionUID = -6259826457388313121L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_seq")
	@SequenceGenerator(name = "phone_seq", sequenceName = "phone_seq", allocationSize = 1)
	private Long id;
	
	private String number;
	
	@ManyToOne
	private Student student;

	public Phone() {
		super();
	}
	
	public Phone(Long id, String number, Student student) {
		super();
		this.id = id;
		this.number = number;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
