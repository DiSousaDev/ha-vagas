package br.dev.diego.havagas.repositories;

import br.dev.diego.havagas.entities.Vaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    Page<Vaga> findAll(Pageable pageable);

}
