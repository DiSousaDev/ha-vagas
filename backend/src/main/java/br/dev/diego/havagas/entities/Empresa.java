package br.dev.diego.havagas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String website;
    private String contato;
    private String emailContato;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Vaga> vagas = new ArrayList<>();

    public Empresa(){
    }

    public Empresa(Long id) {
        this.id = id;
    }

    public Empresa(Long id, String razaoSocial, String cnpj, String website, String contato, String emailContato){
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.website = website;
        this.contato = contato;
        this.emailContato = emailContato;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getRazaoSocial(){
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website = website;
    }

    public String getContato(){
        return contato;
    }

    public void setContato(String contato){
        this.contato = contato;
    }

    public String getEmailContato(){
        return emailContato;
    }

    public void setEmailContato(String emailContato){
        this.emailContato = emailContato;
    }

    public List<Vaga> getVagas(){
        return vagas;
    }

}
