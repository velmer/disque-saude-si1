package com.ufcg.si1.model.unidadesaude;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class PostoSaude extends UnidadeSaude {

    @Column
    private float taxaDiariaAtendimentos;

    public PostoSaude(){
        super();
    }

    public PostoSaude(String descricao, Set<Especialidade> especialidades, int quantidadeMedicos,
                      float taxaDiariaAtendimentos) {
        super(descricao, especialidades, quantidadeMedicos);
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }

    public float getTaxaDiariaAtendimentos() {
        return taxaDiariaAtendimentos;
    }

    @Override
    public String toString() {
        return "PostoSaude{" +
                "taxaDiariaAtendimentos=" + taxaDiariaAtendimentos +
                ", id=" + id +
                ", descricao='" + descricao + '\'' +
                ", especialidades=" + especialidades +
                ", quantidadeMedicos=" + quantidadeMedicos +
                '}';
    }
}
