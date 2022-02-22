package br.dev.diego.havagas.domain.enums;

public enum RegimeTrabalho {

    PRESENCIAL("Presencial"),
    HIBRIDO("Híbrido"),
    HOME_OFFICE("Home Office"),
    NAO_IDENTIFICADO("Não Identificado");


    private String descricao;

    RegimeTrabalho(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
