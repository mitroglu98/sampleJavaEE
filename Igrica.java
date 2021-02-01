package me.fit.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Igrica implements Serializable{
	private static final long serialVersionUID = -6259826457388313121L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "igrica_seq")
	@SequenceGenerator(name = "igrica_seq", sequenceName = "igrica_seq", allocationSize = 1)
	private Long id;
	
	private String number;
	
	@ManyToOne
	private Korisnik korisnik;

	public Igrica() {
		super();
	}
	
	public Igrica(Long id, String number, Korisnik student) {
		super();
		this.id = id;
		this.number = number;
		this.korisnik = korisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
}
