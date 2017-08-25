package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;

@Entity
public class SituacaoPrefeituraCaos extends SituacaoPrefeitura {

    private static final float LIMITE_EFICIENCIA_BAIXA = 0.05F;
    private static final float LIMITE_EFICIENCIA_REGULAR = 0.02F;

    public SituacaoPrefeituraCaos() {
        super(LIMITE_EFICIENCIA_BAIXA, LIMITE_EFICIENCIA_REGULAR);
    }

    @Override
    public String toString() {
        return "SituacaoPrefeituraCaos{" +
                ", limiteEficienciaBaixa=" + limiteEficienciaBaixa +
                ", limiteEficienciaRegular=" + limiteEficienciaRegular +
                '}';
    }
}
