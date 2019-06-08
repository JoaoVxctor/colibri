package br.com.colibri.dao;

import br.com.colibri.models.Projeto;
import br.com.colibri.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public List<Projeto> projetosParticipantes(Long id){
        List<Projeto> projetos = new ArrayList<>();
        Query query = entityManager.createNativeQuery("SELECT DISTINCT projeto_id FROM vw_projeto_participantes WHERE participantes_id  = :id");
        query.setParameter("id",id);
        List<BigInteger> result = query.getResultList();

        for (BigInteger s : result) {
            projetos.add(projetoRepository.findProjetoById(s.longValue()));
        }
         return projetos;
    }
}
