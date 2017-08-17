package com.ufcg.si1.enumeration;

public enum EficienciaPrefeitura {

    RUIM("Ruim"), REGULAR("Regular"), BOM("Bom");

    private final String descricao;

    EficienciaPrefeitura(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
