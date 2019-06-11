package br.com.colibri.dao;

import br.com.colibri.models.Tarefa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;

@Repository
public class TarefaDAO {
    @PersistenceContext
    EntityManager entityManager;


    public void cadastrarTarefa(Tarefa tarefa){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_cadastro_tarefa")
                .registerStoredProcedureParameter("descricao", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("sprint", Long.class, ParameterMode.IN)


                .setParameter("descricao", tarefa.getDescricao())

                .setParameter("sprint", tarefa.getSprint().getId());

        query.execute();
    }

    public void finalizaTarefa(Tarefa tarefa){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_finaliza_tarefa")
                .registerStoredProcedureParameter("id", Long.class, ParameterMode.IN)
                .setParameter("id", tarefa.getId());

        query.execute();
    }

    public void excluirTarefa(Tarefa tarefa){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_cadastro_tarefa")
                .registerStoredProcedureParameter("id", Long.class, ParameterMode.IN)

                .setParameter("id", tarefa.getId());

        query.execute();
    }

}
