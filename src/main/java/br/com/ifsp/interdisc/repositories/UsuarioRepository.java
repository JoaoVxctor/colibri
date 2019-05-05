package br.com.ifsp.interdisc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.ifsp.interdisc.models.Usuario;

@Repository
@Component
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
