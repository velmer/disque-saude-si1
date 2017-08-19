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

    /**
     * Indica se a queixa pode ser resolvida, ou seja, pode assumir o status de
     * "Em Andamento". Uma queixa só pode ser resolvida caso a mesma esteja ante-
     * riormente aberta.
     *
     * @return {@code true} se a queixa pode ser resolvida, {@code false} caso
     * contrário.
     */
    public boolean podeSerResolvida() {
        return this != EM_ANDAMENTO && this != FECHADA;
    }

    /**
     * Indica se a queixa pode ser fechada, ou seja, pode assumir o status de
     * "Fechada". Uma queixa só pode ser fechada caso a mesma não esteja ante-
     * riormente fechada.
     *
     * @return {@code true} se a queixa pode ser fechada, {@code false} caso
     * contrário.
     */
    public boolean podeSerFechada() {
        return this != FECHADA;
    }
}
