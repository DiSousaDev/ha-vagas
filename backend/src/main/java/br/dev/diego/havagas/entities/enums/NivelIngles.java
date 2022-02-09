package br.dev.diego.havagas.entities.enums;

public enum NivelIngles {

    NAO_EXIGIDO("Não Exigido"),
    TECNICO("Técnico"),
    AVANCADO("Avançado");

    private String descricao;

    NivelIngles(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
