package br.com.ifsp.interdisc.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O campo nome não pode ser nulo")
	private String nome;
	@NotNull(message = "O campo e-mail não pode ser nulo")
	private String email;
	@NotNull(message = "O campo senha não pode ser nulo")
	private String senha;
	@NotNull(message = "O campo data de nascimento não pode ser nulo") 
	private Date datansc;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToOne
	private Faculdade faculdade;
	@Enumerated(EnumType.STRING)
	private Curso curso;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDatansc() {
		return datansc;
	}

	public void setDatansc(Date datansc) {
		this.datansc = datansc;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Faculdade getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
