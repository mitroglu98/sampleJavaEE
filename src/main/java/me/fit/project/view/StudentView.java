
package me.fit.project.view;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import me.fit.project.model.Phone;
import me.fit.project.model.Student;
import me.fit.project.service.api.StudentService;
import me.fit.project.service.impl.StudentServiceImpl;

@Named
@ViewScoped
public class StudentView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private StudentService studentService;

	private Student student;

	private List<Student> students;

	private String imeZaPretragu;
	
	private Student selectedStudent;

	@PostConstruct
	public void initNewMember() {
		student = new Student();
		students = studentService.getAllStudents();
	}

	public void addNewStudent() throws Exception {
		try {
			studentService.addStudent(student);
			student = new Student();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			students = studentService.getAllStudents();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not registered", "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public void pretraziPoImenu() {
		if (imeZaPretragu.isEmpty()) {
			students = studentService.getAllStudents();
			return;
		}
		students = studentService.getByName(imeZaPretragu);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getImeZaPretragu() {
		return imeZaPretragu;
	}

	public void setImeZaPretragu(String imeZaPretragu) {
		this.imeZaPretragu = imeZaPretragu;
	}

	public Long getId() {
		return selectedStudent.getId();
	}

	public void setId(Long id) {
		selectedStudent.setId(id);
	}

	public String getName() {
		return selectedStudent.getName();
	}

	public void setName(String name) {
		selectedStudent.setName(name);
	}

	public String getEmail() {
		return selectedStudent.getEmail();
	}

	public void setEmail(String email) {
		selectedStudent.setEmail(email);
	}

	public Set<Phone> getPhones() {
		return selectedStudent.getPhones();
	}

	public void setPhones(Set<Phone> phones) {
		selectedStudent.setPhones(phones);
	}

	public int hashCode() {
		return selectedStudent.hashCode();
	}

	public boolean equals(Object obj) {
		return selectedStudent.equals(obj);
	}

	public String toString() {
		return selectedStudent.toString();
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}
	
	

}
