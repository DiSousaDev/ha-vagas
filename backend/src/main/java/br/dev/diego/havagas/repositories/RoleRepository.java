package br.dev.diego.havagas.repositories;

import br.dev.diego.havagas.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
