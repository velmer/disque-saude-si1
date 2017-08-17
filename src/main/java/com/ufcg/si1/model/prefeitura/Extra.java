package com.ufcg.si1.model.prefeitura;

public class Extra extends SituacaoPrefeitura {

    private static final double LIMITE_RUIM = 0.1;
    private static final double LIMITE_REGULAR = 0.05;

    public Extra() {
        this.limiteRuim = LIMITE_RUIM;
        this.limiteRegular = LIMITE_REGULAR;
    }
}
