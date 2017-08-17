package com.ufcg.si1.model.prefeitura;

public class Caos extends SituacaoPrefeitura {

    private static final double LIMITE_RUIM = 0.05;
    private static final double LIMITE_REGULAR = 0.02;

    public Caos() {
        this.limiteRuim = LIMITE_RUIM;
        this.limiteRegular = LIMITE_REGULAR;
    }
}
