package br.com.ifsp.interdisc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Forum {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Comentarios comentarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comentarios getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentarios comentarios) {
		this.comentarios = comentarios;
	}

}
