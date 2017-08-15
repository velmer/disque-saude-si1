package com.ufcg.si1.model;


import java.util.Set;

public class PostoSaude extends UnidadeSaude{

    private int taxaDiariaAtendimentos;

    public PostoSaude(){
        super();
    }

    public PostoSaude(String descricao, Set<Especialidade> especialidades, int quantidadeMedicos,
                      int taxaDiariaAtendimentos) {
        super(descricao, especialidades, quantidadeMedicos);
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }

    public int getTaxaDiariaAtendimentos() {
        return taxaDiariaAtendimentos;
    }
}
