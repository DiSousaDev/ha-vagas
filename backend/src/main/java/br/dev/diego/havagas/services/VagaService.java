package br.dev.diego.havagas.services;

import br.dev.diego.havagas.entities.AreaAtuacao;
import br.dev.diego.havagas.entities.Empresa;
import br.dev.diego.havagas.entities.Vaga;
import br.dev.diego.havagas.entities.dto.VagaDTO;
import br.dev.diego.havagas.entities.dto.VagaInsertDTO;
import br.dev.diego.havagas.repositories.VagaRepository;
import br.dev.diego.havagas.services.exceptions.ResourceNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Transactional(readOnly = true)
    public Page<VagaDTO> findAllPaged(Pageable pageable) {
        Page<Vaga> vagas = vagaRepository.findAll(pageable);
        return vagas.map(obj -> new VagaDTO(obj));
    }

    @Transactional(readOnly = true)
    public VagaDTO findById(Long id){
        Optional<Vaga> obj = vagaRepository.findById(id);
        Vaga vaga = obj.orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrada."));
        return new VagaDTO(vaga);
    }

    @Transactional
    public VagaDTO insert(VagaInsertDTO vagaInsertDTO){
        Vaga vaga = new Vaga();
        copyDTOToEntity(vagaInsertDTO, vaga);
        vaga = vagaRepository.save(vaga);
        return new VagaDTO(vaga);
    }

    private void copyDTOToEntity(VagaInsertDTO vagaInsertDTO, Vaga vaga){
        vaga.setTitulo(vagaInsertDTO.getTitulo());
        vaga.setEstado(vagaInsertDTO.getEstado());
        vaga.setDescricao(vagaInsertDTO.getDescricao());
        vaga.setAutomacao(vagaInsertDTO.getAutomacao());
        vaga.setNivelCarreira(vagaInsertDTO.getNivelCarreira());
        vaga.setNivelIngles(vagaInsertDTO.getNivelIngles());
        vaga.setRegimeTrabalho(vagaInsertDTO.getRegimeTrabalho());
        vaga.setDataAtualizacao(vagaInsertDTO.getDataAtualizacao());
        vaga.setEmpresa(new Empresa(vagaInsertDTO.getEmpresa()));
        vaga.setAreaAtuacao(new AreaAtuacao(vagaInsertDTO.getAreaAtuacao()));
    }
}
