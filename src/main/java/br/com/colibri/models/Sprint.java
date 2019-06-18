package br.com.colibri.models;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @OneToMany(mappedBy = "sprint",fetch = FetchType.EAGER)
    private Set<Tarefa> tarefas;
    private String nome;
    @ManyToOne
    private Projeto projeto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Sprint(Long id, LocalDate dataInicio, LocalDate dataFim, Set<Tarefa> tarefas, String nome, Projeto projeto) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tarefas = tarefas;
        this.nome = nome;
        this.projeto = projeto;
    }

    public Sprint() {
    }
}
