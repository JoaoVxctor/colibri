package br.com.colibri.services;

import br.com.colibri.dao.ProjetoDAO;
import br.com.colibri.models.Projeto;
import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetoService {
    private ProjetoRepository projetoRepository;
    private UsuarioService usuarioService;
    private EntityManager entityManager;
    private ProjetoDAO projetoDAO;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository, UsuarioService usuarioService, EntityManager entityManager, ProjetoDAO projetoDAO) {
        this.projetoRepository = projetoRepository;
        this.usuarioService = usuarioService;
        this.entityManager = entityManager;
        this.projetoDAO = projetoDAO;
    }

    public boolean novoProjeto(Projeto projeto) {
        try {
            List<Usuario> discard = new ArrayList<>();
            for (Usuario usuario : projeto.getParticipantes()) {
                System.out.println(usuario.toString());
                Usuario participante = null;
                participante = usuarioService.findUsuarioByEmail(usuario.getEmail());
                if (participante == null) {
                    System.out.println("paticipante " + usuario.getEmail() + " não encontrado");
                    return false;
                }
            }


            projetoDAO.cadastroProjeto(projeto);
            System.out.println("projeto " + projeto.getId() + " Salvo");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("nada deu certo");
            return false;
        }

        return true;
    }

    public  Projeto findProjetoById(Long id){
        return projetoRepository.findProjetoById(id);
    }

    public List<Projeto> findProjetoByParticipante(Long id, Integer limit){
        return projetoDAO.projetosParticipantes(id, limit);
    }

}
