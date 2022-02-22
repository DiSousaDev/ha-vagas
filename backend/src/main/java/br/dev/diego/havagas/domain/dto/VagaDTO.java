package br.dev.diego.havagas.domain.dto;

import br.dev.diego.havagas.domain.enums.Automacao;
import br.dev.diego.havagas.domain.enums.NivelCarreira;
import br.dev.diego.havagas.domain.enums.NivelIngles;
import br.dev.diego.havagas.domain.enums.RegimeTrabalho;
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
