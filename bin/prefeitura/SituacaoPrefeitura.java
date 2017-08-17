package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;

public abstract class SituacaoPrefeitura {

    protected double limiteRuim;
    protected double limiteRegular;

    public EficienciaPrefeitura getEficiencia(double proporcaoQueixasAberta) {
        EficienciaPrefeitura eficiencia;

        if (proporcaoQueixasAberta > this.limiteRuim)
            eficiencia = EficienciaPrefeitura.RUIM;
        else if (proporcaoQueixasAberta > this.limiteRegular)
            eficiencia = EficienciaPrefeitura.REGULAR;
        else
            eficiencia = EficienciaPrefeitura.BOM;

        return  eficiencia;
    }

}
