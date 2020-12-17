package me.fit.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
	@SequenceGenerator(name = "subject_seq", sequenceName = "subject_seq", allocationSize = 1)
	private Long id;

	private String name;

	private int numECTSCredits;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "subject", fetch = FetchType.EAGER)
	private Set<StudentSubject> studentSubjects;
}
