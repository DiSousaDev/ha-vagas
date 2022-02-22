package br.dev.diego.havagas.domain.mapper;

import br.dev.diego.havagas.domain.dto.VagaDTO;
import br.dev.diego.havagas.entities.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VagaMapper {

    @Mapping(target = "empresa", source = "empresa.id")
    @Mapping(target = "areaAtuacao", source = "areaAtuacao.id")
    VagaDTO vagaToVagaDto(Vaga vaga);

}
