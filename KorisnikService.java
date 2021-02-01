package me.fit.project.service.api;

import java.util.List;

import me.fit.project.model.Igrica;
import me.fit.project.model.Korisnik;

public interface KorisnikService {
	public void dodajKorisnika(Korisnik korisnik) throws Exception;
	public Korisnik findById(Long id);

	public List<Korisnik> uzmiSveKorisnike();

	public List<Korisnik> getByName(String nameP);
}
