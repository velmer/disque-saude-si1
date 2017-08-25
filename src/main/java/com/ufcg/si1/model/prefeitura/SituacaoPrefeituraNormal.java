package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;

@Entity
public class SituacaoPrefeituraNormal extends SituacaoPrefeitura {

    private static final float LIMITE_EFICIENCIA_BAIXA = 0.2F;
    private static final float LIMITE_EFICIENCIA_REGULAR = 0.1F;

    public SituacaoPrefeituraNormal() {
        super(LIMITE_EFICIENCIA_BAIXA, LIMITE_EFICIENCIA_REGULAR);
    }

    @Override
    public String toString() {
        return "SituacaoPrefeituraNormal{" +
                "limiteEficienciaBaixa=" + limiteEficienciaBaixa +
                ", limiteEficienciaRegular=" + limiteEficienciaRegular +
                '}';
    }

}
