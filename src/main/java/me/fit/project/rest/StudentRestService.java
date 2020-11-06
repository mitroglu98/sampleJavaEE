package me.fit.project.rest;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/students")
@RequestScoped
public class StudentRestService {

	@Inject
	private Logger log;

}
