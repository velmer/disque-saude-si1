package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;

public abstract class Prefeitura {

    protected float limiteProporcaoInferior;
    protected float limiteProporcaoSuperior;

    public Prefeitura(float limiteProporcaoInferior, float limiteProporcaoSuperior) {
        this.limiteProporcaoInferior = limiteProporcaoInferior;
        this.limiteProporcaoSuperior = limiteProporcaoSuperior;
    }

    public abstract EficienciaPrefeitura calculaEficiencia(float proporcaoQueixas);
}
