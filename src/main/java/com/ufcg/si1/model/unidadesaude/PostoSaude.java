package com.ufcg.si1.model.unidadesaude;

import java.util.Set;

public class PostoSaude extends UnidadeSaude{

    private float taxaDiariaAtendimentos;

    public PostoSaude(){
        super();
    }

    public PostoSaude(String descricao, Set<Especialidade> especialidades, int quantidadeMedicos,
                      int taxaDiariaAtendimentos) {
        super(descricao, especialidades, quantidadeMedicos);
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }

    public float getTaxaDiariaAtendimentos() {
        return taxaDiariaAtendimentos;
    }
}
