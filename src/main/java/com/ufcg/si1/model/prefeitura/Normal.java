package com.ufcg.si1.model.prefeitura;

public class Normal extends SituacaoPrefeitura {

    private static final double LIMITE_RUIM = 0.2;
    private static final double LIMITE_REGULAR = 0.1;

    public Normal() {
        this.limiteRuim = LIMITE_RUIM;
        this.limiteRegular = LIMITE_REGULAR;
    }
}
