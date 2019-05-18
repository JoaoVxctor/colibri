package br.com.colibri.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    @Size(min=4,max=50)
    private String nome;
    @Size(min = 1, message = "O campo e-mail não pode ser nulo ou vazio")
    @Email
    private String email;
    @NotEmpty(message = "O campo senha não pode ser nulo")
    private String senha;
    @NotNull(message = "O campo data de nascimento não pode ser nulo")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datanasc;
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

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
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

    public Usuario(Long id, @NotNull(message = "O campo nome não pode ser nulo") String nome, @NotNull(message = "O campo e-mail não pode ser nulo") @Email String email, @NotNull(message = "O campo senha não pode ser nulo") String senha, @NotNull(message = "O campo data de nascimento não pode ser nulo") Date datanasc, Genero genero, Role role, Faculdade faculdade, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.datanasc = datanasc;
        this.genero = genero;
        this.role = role;
        this.faculdade = faculdade;
        this.curso = curso;
    }

    public Usuario() {
    }
}
