package com.ufcg.si1.model.unidadesaude;

import br.edu.ufcg.Hospital;
import com.ufcg.si1.model.Endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

@Table(name = "TB_HOSPITAL")
@Entity
public class HospitalAdapter extends UnidadeSaude {

    @Transient
    private Hospital hospital;

    @Column
    private float numeroPacientesDia;

    public HospitalAdapter() { super(); }

    public HospitalAdapter(String descricao, Endereco endereco, Set<Especialidade> especialidades, int quantidadeMedicos,
                           float numeroPacientesDia) {
        super(descricao, endereco, especialidades, quantidadeMedicos);

        this.numeroPacientesDia = numeroPacientesDia;
        this.hospital = new Hospital(descricao, quantidadeMedicos, numeroPacientesDia);
    }

    public float getTaxaPacientesPorDia() {
        return this.numeroPacientesDia;
    }

    @Override
    public String toString() {
        return "HospitalAdapter{" +
                "numeroPacientesDia=" + numeroPacientesDia +
                ", id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", especialidades=" + especialidades +
                ", quantidadeMedicos=" + quantidadeMedicos +
                '}';
    }
}
