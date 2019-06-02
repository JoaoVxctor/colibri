package br.com.colibri.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 4, max = 50)
	private String nome;
	@Size(min = 1, message = "O campo e-mail não pode ser nulo ou vazio")
	@Email
	private String email;
	@NotEmpty(message = "O campo senha não pode ser nulo")
	private String senha;
	@NotNull(message = "O campo data de nascimento não pode ser nulo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datanasc;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	@ManyToMany
	private Set<Role> role;

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				", datanasc=" + datanasc +
				", genero=" + genero +
				", role=" + role +
				", ativo=" + ativo +
				'}';
	}

	private Boolean ativo;

	public Usuario(Long id, @NotNull @Size(min = 4, max = 50) String nome,
			@Size(min = 1, message = "O campo e-mail não pode ser nulo ou vazio") @Email String email,
			@NotEmpty(message = "O campo senha não pode ser nulo") String senha,
			@NotNull(message = "O campo data de nascimento não pode ser nulo") LocalDate datanasc, Genero genero,
			Set<Role> role, Boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.datanasc = datanasc;
		this.genero = genero;
		this.role = role;

		this.ativo = ativo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public LocalDate getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Usuario() {
	}
}
