package me.fit.project.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import me.fit.project.model.Student;
import me.fit.project.service.api.StudentService;

@Stateless
public class StudentServiceImpl implements StudentService {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void addStudent(Student student) throws Exception {
		log.info("Registering " + student.getName());
		em.persist(student);
	}

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public List<Student> getAllStudents() {
		return em.createNamedQuery(Student.GET_ALL, Student.class).getResultList();
	}

	public List<Student> getByName(String nameP) {
		return em.createNamedQuery(Student.GET_BY_NAME, Student.class).setParameter("ime", nameP).getResultList();
	}

}
