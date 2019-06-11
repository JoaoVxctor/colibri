package br.com.colibri.dao;

import br.com.colibri.models.Sprint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;

@Repository
public class SprintDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void cadastroSprint(Sprint sprint){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_cadastro_sprint")
                .registerStoredProcedureParameter("nome", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("data_inicio", LocalDate.class, ParameterMode.IN)
                .registerStoredProcedureParameter("projeto", Long.class, ParameterMode.IN)

                .setParameter("nome", sprint.getNome())
                .setParameter("data_inicio", sprint.getDataInicio())
                .setParameter("projeto", sprint.getProjeto().getId());

        query.execute();
    }
    public void deleteSprint(Sprint sprint){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_delete_sprint")
                .registerStoredProcedureParameter("sprint", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("projeto", Long.class, ParameterMode.IN)

                .setParameter("projeto", sprint.getProjeto().getId())
                .setParameter("sprint", sprint.getId());

        query.execute();
    }
}
