package com.ufcg.si1.enumeration;

public enum EficienciaPrefeitura {

    BAIXA("Baixa"), REGULAR("Regular"), ALTA("Alta");

    private final String descricao;

    EficienciaPrefeitura(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
