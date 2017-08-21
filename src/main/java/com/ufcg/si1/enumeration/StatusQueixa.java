package com.ufcg.si1.enumeration;

public enum StatusQueixa {

    FECHADA("Fechada"), EM_ANDAMENTO("Em Andamento"), ABERTA("Aberta");

    private final String descricao;

    StatusQueixa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
