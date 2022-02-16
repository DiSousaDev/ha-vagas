package br.dev.diego.havagas.controllers;

import br.dev.diego.havagas.entities.dto.VagaDTO;
import br.dev.diego.havagas.entities.dto.VagaInsertDTO;
import br.dev.diego.havagas.services.VagaService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/vagas")
public class VagaController {

    @Autowired
    private VagaService service;

    @GetMapping
    public ResponseEntity<Page<VagaDTO>> findAll(Pageable pageable) {
        Page<VagaDTO> vagas = service.findAllPaged(pageable);
        return ResponseEntity.ok(vagas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VagaDTO> findById(@PathVariable Long id) {
        VagaDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<VagaDTO> insert(@RequestBody VagaInsertDTO vagaInsertDTO) {
        VagaDTO vagaDTO = service.insert(vagaInsertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(vagaDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(vagaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDTO> update(@PathVariable Long id, @RequestBody VagaInsertDTO vagaInsertDTO) {
        VagaDTO vagaDTO = service.update(id, vagaInsertDTO);
        return ResponseEntity.ok().body(vagaDTO);
    }

}
