package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;

public class PrefeituraNormal extends Prefeitura {

    private static final float LIMITE_EFICIENCIA_BAIXA = 0.2F;
    private static final float LIMITE_EFICIENCIA_REGULAR = 0.1F;

    public PrefeituraNormal() {
        super(LIMITE_EFICIENCIA_BAIXA, LIMITE_EFICIENCIA_REGULAR);
    }

}
