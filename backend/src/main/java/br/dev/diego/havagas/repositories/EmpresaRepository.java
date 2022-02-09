package br.dev.diego.havagas.repositories;

import br.dev.diego.havagas.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
