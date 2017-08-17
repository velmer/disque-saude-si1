package com.ufcg.si1.model.unidadesaude;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Especialidade {

    @Column(name = "ESPECIALIDADE")
    private String descricao;

    public Especialidade() {}

    public Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
