package com.ufcg.si1.model.unidadesaude;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Especialidade {

    @Column(name = "especialidade")
    private String descricao;

    public Especialidade() {}

    public Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Especialidade that = (Especialidade) o;

        return descricao.equals(that.descricao);
    }

    @Override
    public int hashCode() {
        return descricao.hashCode();
    }
}
