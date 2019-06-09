package br.com.colibri.dao;

import br.com.colibri.models.Projeto;
import br.com.colibri.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjetoDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoDAO(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> projetosParticipantes(Long id, Integer limite) {
        List<Projeto> projetos = new ArrayList<>();
        Query query = entityManager.createNativeQuery("SELECT DISTINCT projeto_id FROM vw_projeto_participantes WHERE participantes_id  = :id LIMIT :limit");
        query.setParameter("id", id);
        query.setParameter("limit", limite);
        List<BigInteger> result = query.getResultList();

        for (BigInteger s : result) {

            projetos.add(projetoRepository.findProjetoById(s.longValue()));
        }
        return projetos;
    }

    public Boolean cadastroProjeto(Projeto projeto) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_cadastro_projeto")
                    .registerStoredProcedureParameter("nome", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("descricao", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("criador", Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("participante_2", Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("participante_3", Long.class, ParameterMode.IN)
                    .setParameter("nome", projeto.getNome())
                    .setParameter("descricao", projeto.getDescricao())
                    .setParameter("criador", projeto.getCriador().getId())
                    .setParameter("participante_2", projeto.getParticipantes().get(1).getId())
                    .setParameter("participante_3", projeto.getParticipantes().get(2).getId());

            query.execute();

        return true;

    }
}
