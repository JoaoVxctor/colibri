package br.com.colibri.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDateTime dataCriacao;
	private LocalDateTime data;
	private String descricao;
	private double nota;
	@OneToOne
	private Usuario criador;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Usuario> participantes;
	@ManyToMany
	private List<Avaliacao> avaliacao;
	@ManyToMany
	private List<Sprint> sprint;

	public Projeto(Long id, String nome, LocalDateTime dataCriacao, LocalDateTime data, String descricao, double nota, Usuario criador, List<Usuario> participantes, List<Avaliacao> avaliacao, List<Sprint> sprint) {
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.data = data;
		this.descricao = descricao;
		this.nota = nota;
		this.criador = criador;
		this.participantes = participantes;
		this.avaliacao = avaliacao;
		this.sprint = sprint;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Sprint> getSprint() {
		return sprint;
	}

	public void setSprint(List<Sprint> sprint) {
		this.sprint = sprint;
	}

	public Projeto() {
	}
}
