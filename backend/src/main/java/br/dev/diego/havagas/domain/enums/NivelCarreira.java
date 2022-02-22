package br.dev.diego.havagas.domain.enums;

public enum NivelCarreira {

    ESTAGIO("Estágio"),
    JUNIOR("Junior"),
    PLENO("Pleno"),
    SENIO("Senio");

    private String descricao;

    NivelCarreira(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
