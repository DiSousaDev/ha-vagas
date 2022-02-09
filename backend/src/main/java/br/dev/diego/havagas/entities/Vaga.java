package br.dev.diego.havagas.entities;

import br.dev.diego.havagas.entities.enums.Automacao;
import br.dev.diego.havagas.entities.enums.NivelCarreira;
import br.dev.diego.havagas.entities.enums.NivelIngles;
import br.dev.diego.havagas.entities.enums.RegimeTrabalho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tb_vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String estado;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Automacao automacao;

    @Enumerated(EnumType.STRING)
    private NivelCarreira nivelCarreira;

    @Enumerated(EnumType.STRING)
    private NivelIngles nivelIngles;

    @Enumerated(EnumType.STRING)
    private RegimeTrabalho regimeTrabalho;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToOne
    private AreaAtuacao areaAtuacao;

    public Vaga(){
    }

    public Vaga(Long id, String titulo, String estado, String descricao, String automacao, String nivelCarreira,
            String nivelIngles, String regimeTrabalho, Instant dataAtualizacao, Empresa empresa, AreaAtuacao areaAtuacao){
        this.id = id;
        this.titulo = titulo;
        this.estado = estado;
        this.descricao = descricao;
        this.automacao = Automacao.valueOf(automacao);
        this.nivelCarreira = NivelCarreira.valueOf(nivelCarreira);
        this.nivelIngles = NivelIngles.valueOf(nivelIngles);
        this.regimeTrabalho = RegimeTrabalho.valueOf(regimeTrabalho);
        this.dataAtualizacao = dataAtualizacao;
        this.empresa = empresa;
        this.areaAtuacao = areaAtuacao;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Automacao getAutomacao(){
        return automacao;
    }

    public void setAutomacao(Automacao automacao){
        this.automacao = automacao;
    }

    public NivelCarreira getNivelCarreira(){
        return nivelCarreira;
    }

    public void setNivelCarreira(NivelCarreira nivelCarreira){
        this.nivelCarreira = nivelCarreira;
    }

    public NivelIngles getNivelIngles(){
        return nivelIngles;
    }

    public void setNivelIngles(NivelIngles nivelIngles){
        this.nivelIngles = nivelIngles;
    }

    public RegimeTrabalho getRegimeTrabalho(){
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(RegimeTrabalho regimeTrabalho){
        this.regimeTrabalho = regimeTrabalho;
    }

    public Instant getDataAtualizacao(){
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao){
        this.dataAtualizacao = dataAtualizacao;
    }

    public Empresa getEmpresa(){
        return empresa;
    }

    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    public AreaAtuacao getAreaAtuacao(){
        return areaAtuacao;
    }

    public void setAreaAtuacao(AreaAtuacao areaAtuacao){
        this.areaAtuacao = areaAtuacao;
    }
}
