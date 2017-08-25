package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;

@Entity
public class SituacaoPrefeituraExtra extends SituacaoPrefeitura {

    private static final float LIMITE_EFICIENCIA_BAIXA = 0.1F;
    private static final float LIMITE_EFICIENCIA_REGULAR = 0.05F;

    public SituacaoPrefeituraExtra() {
        super(LIMITE_EFICIENCIA_BAIXA, LIMITE_EFICIENCIA_REGULAR);
    }

    @Override
    public String toString() {
        return "SituacaoPrefeituraExtra{" +
                "limiteEficienciaBaixa=" + limiteEficienciaBaixa +
                ", limiteEficienciaRegular=" + limiteEficienciaRegular +
                '}';
    }
}
