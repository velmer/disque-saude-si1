package com.ufcg.si1.model.unidadesaude;

import com.ufcg.si1.model.Endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "TB_POSTO_SAUDE")
@Entity
public class PostoSaude extends UnidadeSaude {

    @Column
    private float taxaPacientesPorDia;

    public PostoSaude(){
        super();
    }

    public PostoSaude(String descricao, Endereco endereco, Set<Especialidade> especialidades, int quantidadeMedicos,
                      float taxaPacientesPorDia) {
        super(descricao, endereco, especialidades, quantidadeMedicos);
        this.taxaPacientesPorDia = taxaPacientesPorDia;
    }

    public float getTaxaPacientesPorDia() {
        return this.taxaPacientesPorDia;
    }

    @Override
    public String toString() {
        return "PostoSaude{" +
                "taxaPacientesPorDia=" + taxaPacientesPorDia +
                ", id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", especialidades=" + especialidades +
                ", quantidadeMedicos=" + quantidadeMedicos +
                '}';
    }
}
