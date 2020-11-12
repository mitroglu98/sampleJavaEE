package me.fit.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import me.fit.project.model.Student;
import me.fit.project.service.api.StudentService;

public class StudentServiceMock implements StudentService {

	@Override
	public void addStudent(Student student) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		Student s1 = new Student(1L, "marko", "marko@example.com", "069123456");
		Student s2 = new Student(2L, "petar", "marko@example.com", "069123456");
		Student s3 = new Student(3L, "jovan", "marko@example.com", "069123456");

		students.add(s1);
		students.add(s2);
		students.add(s3);

		return students;
	}

	@Override
	public List<Student> getByName(String nameP) {
		// TODO Auto-generated method stub
		return null;
	}

}
