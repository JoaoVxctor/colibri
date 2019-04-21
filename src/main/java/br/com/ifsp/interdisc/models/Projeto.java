package br.com.ifsp.interdisc.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private LocalDateTime dataCriacao;
	private LocalDateTime data;
	private double nota;
	@OneToOne
	private Usuario criador;
	@ManyToOne
	private Usuario participantes;
	@ManyToOne
	private Avaliacao avaliacao;
	@ManyToOne
	private Documento documento;
	@OneToOne
	private Forum forum;

	public Usuario getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Usuario participantes) {
		this.participantes = participantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Usuario getIdCriador() {
		return criador;
	}

	public void setIdCriador(Usuario criador) {
		this.criador = criador;
	}

}
