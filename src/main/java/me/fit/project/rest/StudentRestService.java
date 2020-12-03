package me.fit.project.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.fit.project.model.Student;
import me.fit.project.service.api.StudentService;
import me.fit.project.service.impl.StudentServiceImpl;

@Path("/students")
@RequestScoped
public class StudentRestService {

	@Inject
	private Logger log;

	@Inject
	private StudentService studentService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllStudents() {
		List<Student> students = studentService.getAllStudents();

		return Response.ok(students).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addStudent")
	public void getAllStudents(Student s) {
		try {
			studentService.addStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
