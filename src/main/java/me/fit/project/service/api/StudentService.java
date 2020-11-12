package me.fit.project.service.api;

import java.util.List;

import me.fit.project.model.Student;

public interface StudentService {
	public void addStudent(Student student) throws Exception;

	public Student findById(Long id);

	public List<Student> getAllStudents();

	public List<Student> getByName(String nameP);
}
