package br.com.colibri.repositories;

import br.com.colibri.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.colibri.models.Projeto;

import java.util.List;

@Repository


public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	List<Projeto> findProjetosByParticipantes(Usuario Participantes);
	Projeto findProjetoById(Long id);
}
