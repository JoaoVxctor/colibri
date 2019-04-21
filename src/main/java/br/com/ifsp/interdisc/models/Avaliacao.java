package br.com.ifsp.interdisc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private double nota;
	@ManyToOne
	private Usuario avaliador;
	@ManyToOne
	private Projeto projeto;

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

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

	public Usuario getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Usuario avaliador) {
		this.avaliador = avaliador;
	}

}
