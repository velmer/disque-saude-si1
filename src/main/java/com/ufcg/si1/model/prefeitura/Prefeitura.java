package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;

public abstract class Prefeitura {

    protected float limiteEficienciaBaixa;
    protected float limiteEficienciaRegular;

    public Prefeitura(float limiteEficienciaBaixa, float limiteEficienciaRegular) {
        this.limiteEficienciaBaixa = limiteEficienciaBaixa;
        this.limiteEficienciaRegular = limiteEficienciaRegular;
    }

    /**
     * Retorna a eficiência da Prefeitura de acordo com o seu estado e a proporção entre
     * queixas abertas e fechadas.
     *
     * @param proporcaoQueixas Proporção entre queixas abertas e fechadas.
     * @return EficienciaPrefeitura Enum que indica qual a eficiência da prefeitura.
     */
    public EficienciaPrefeitura getEficiencia(float proporcaoQueixas) {
        if (proporcaoQueixas > limiteEficienciaBaixa)
            return EficienciaPrefeitura.BAIXA;
        else if (proporcaoQueixas > limiteEficienciaRegular)
            return EficienciaPrefeitura.REGULAR;
        else
            return EficienciaPrefeitura.ALTA;
    }

}
