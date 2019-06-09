package br.com.colibri.dao;

import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.Date;

@Repository
public class UsuarioDAO  {
    @PersistenceContext
    private EntityManager entityManager;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioDAO(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(Usuario usuario){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("pc_cadastro_usuario")
                .registerStoredProcedureParameter("nome",String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("email",String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("senha",String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("datanasc", LocalDate.class, ParameterMode.IN)
                .setParameter("nome",usuario.getNome())
                .setParameter("email",usuario.getEmail())
                .setParameter("senha",usuario.getSenha())
                .setParameter("datanasc",usuario.getDatanasc());
        query.execute();
    }
}
