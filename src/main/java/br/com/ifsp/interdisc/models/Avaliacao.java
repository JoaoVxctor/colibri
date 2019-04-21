package br.com.ifsp.interdisc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private double nota;
	private Avaliador avaliador;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

}
