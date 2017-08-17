package com.ufcg.si1.model.vigilanciasanitaria;

import com.ufcg.si1.model.vigilanciasanitaria.queixa.Queixa;

import java.util.List;

public class VigilanciaSanitaria {

    private List<Queixa> queixas;

    public VigilanciaSanitaria() {}

    public VigilanciaSanitaria(List<Queixa> queixas) {
        this.queixas = queixas;
    }

    public List<Queixa> getQueixas() {
        return queixas;
    }
}
