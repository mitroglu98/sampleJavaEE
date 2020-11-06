package me.fit.project.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import me.fit.project.model.Student;

@Stateless
public class StudentService {

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

	// public Student findByEmail(String email) {
	// CriteriaBuilder cb = em.getCriteriaBuilder();
	// CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
	// Root<Student> member = criteria.from(Student.class);
	// criteria.select(member).where(cb.equal(member.get("email"), email));
	// return em.createQuery(criteria).getSingleResult();
	// }
	//
	// public List<Student> findAllOrderedByName() {
	// CriteriaBuilder cb = em.getCriteriaBuilder();
	// CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
	// Root<Student> member = criteria.from(Student.class);
	// criteria.select(member).orderBy(cb.asc(member.get("name")));
	// return em.createQuery(criteria).getResultList();
	// }
}
