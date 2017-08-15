package com.ufcg.si1.enumeration;

import exceptions.OperacaoInvalidaException;

public enum SituacaoQueixa {

    FECHADA("Fechada"), EM_ANDAMENTO("Em Andamento"), ABERTA("Aberta");

    private final String descricaoSituacao;

    SituacaoQueixa(String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
    }

    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }

    public boolean podeSerFechada() {
        return this != FECHADA;
    }
}
