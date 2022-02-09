package br.dev.diego.havagas.entities.dto;

import br.dev.diego.havagas.entities.Vaga;
import br.dev.diego.havagas.entities.enums.Automacao;
import br.dev.diego.havagas.entities.enums.NivelCarreira;
import br.dev.diego.havagas.entities.enums.NivelIngles;
import br.dev.diego.havagas.entities.enums.RegimeTrabalho;
import java.time.Instant;

public class VagaDTO {

    private Long id;
    private String titulo;
    private String estado;
    private String descricao;
    private Automacao automacao;
    private NivelCarreira nivelCarreira;
    private NivelIngles nivelIngles;
    private RegimeTrabalho regimeTrabalho;
    private Instant dataAtualizacao;
    private Long empresa;
    private Long areaAtuacao;

    public VagaDTO(){
    }

    public VagaDTO(Long id, String titulo, String estado, String descricao, Automacao automacao, NivelCarreira nivelCarreira,
        NivelIngles nivelIngles, RegimeTrabalho regimeTrabalho, Instant dataAtualizacao, Long empresa, Long areaAtuacao) {
        this.id = id;
        this.titulo = titulo;
        this.estado = estado;
        this.descricao = descricao;
        this.automacao = automacao;
        this.nivelCarreira = nivelCarreira;
        this.nivelIngles = nivelIngles;
        this.regimeTrabalho = regimeTrabalho;
        this.dataAtualizacao = dataAtualizacao;
        this.empresa = empresa;
        this.areaAtuacao = areaAtuacao;
    }

    public VagaDTO(Vaga entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        estado = entity.getEstado();
        descricao = entity.getDescricao();
        automacao = entity.getAutomacao();
        nivelCarreira = entity.getNivelCarreira();
        nivelIngles = entity.getNivelIngles();
        regimeTrabalho = entity.getRegimeTrabalho();
        dataAtualizacao = entity.getDataAtualizacao();
        empresa = entity.getEmpresa().getId();
        areaAtuacao = entity.getAreaAtuacao().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Automacao getAutomacao() {
        return automacao;
    }

    public void setAutomacao(Automacao automacao) {
        this.automacao = automacao;
    }

    public NivelCarreira getNivelCarreira() {
        return nivelCarreira;
    }

    public void setNivelCarreira(NivelCarreira nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }

    public NivelIngles getNivelIngles() {
        return nivelIngles;
    }

    public void setNivelIngles(NivelIngles nivelIngles) {
        this.nivelIngles = nivelIngles;
    }

    public RegimeTrabalho getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(RegimeTrabalho regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public Long getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(Long areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
