package com.ufcg.si1.enumeration;

public enum SituacaoQueixa {

    FECHADA("Fechada"), EM_ANDAMENTO("Em Andamento"), ABERTA("Aberta");

    private final String descricao;

    SituacaoQueixa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean podeSerIniciada() {
        return this != EM_ANDAMENTO;
    }

    public boolean podeSerFechada() {
        return this != FECHADA;
    }
}
