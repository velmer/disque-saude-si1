package com.ufcg.si1.model.prefeitura;

public class PrefeituraExtra extends Prefeitura {

    private static final float LIMITE_EFICIENCIA_BAIXA = 0.1F;
    private static final float LIMITE_EFICIENCIA_REGULAR = 0.05F;

    public PrefeituraExtra() {
        super(LIMITE_EFICIENCIA_BAIXA, LIMITE_EFICIENCIA_REGULAR);
    }

}
