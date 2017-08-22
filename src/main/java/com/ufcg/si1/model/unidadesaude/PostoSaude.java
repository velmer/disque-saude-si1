package com.ufcg.si1.model.unidadesaude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "TB_POSTO_SAUDE")
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

    public float getMediaMedicoPorPaciente() {
        if (this.taxaDiariaAtendimentos == 0) // FIXME: Melhorar tratamento e utilizar constantes
            throw new RuntimeException("Taca diária de atendimentos não pode ser zero.");

        return this.quantidadeMedicos / this.taxaDiariaAtendimentos;
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
