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

import me.fit.project.model.Korisnik;
import me.fit.project.service.api.KorisnikService;
import me.fit.project.service.impl.KorisnikServiceImpl;

@Path("/students")
@RequestScoped
public class KorisnikRestService {

	@Inject
	private Logger log;

	@Inject
	private KorisnikService korisnikService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllStudents() {
		List<Korisnik> korisnici = korisnikService.uzmiSveKorisnike();

		return Response.ok(korisnici).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addStudent")
	public void getAllStudents(Korisnik s) {
		try {
			korisnikService.dodajKorisnika(s);;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findStudent")
	public Response findStudentByName(@QueryParam("name") String ime) {
		try {
			List<Korisnik> korisnici = korisnikService.getByName(ime);

			return Response.ok(korisnici).build();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}
