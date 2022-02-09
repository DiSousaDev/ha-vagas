package br.dev.diego.havagas.entities.enums;

public enum Automacao {

    EXIGIDO("Exigido"),
    NAO_EXIGIDO("Não Exigido");

    private String descricao;

    Automacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
