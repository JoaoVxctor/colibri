package br.com.colibri.repositories;

import br.com.colibri.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
