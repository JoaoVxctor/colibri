package br.com.colibri.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Faculdade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFaculdade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFaculdade() {
		return nomeFaculdade;
	}

	public void setNomeFaculdade(String nomeFaculdade) {
		this.nomeFaculdade = nomeFaculdade;
	}

}
