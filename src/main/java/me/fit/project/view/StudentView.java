
package me.fit.project.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import me.fit.project.model.Student;
import me.fit.project.service.StudentService;

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

}
