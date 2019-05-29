package br.com.colibri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.colibri.models.Projeto;

@Repository


public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	
	
}
