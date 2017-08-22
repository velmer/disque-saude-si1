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

    // FIXME: What in the hell should I put here?
    @Transient
    private Hospital hospital;

    @Column // TODO: Remover esse campo e passar a utilizar somente o dado do Hospital da lib. Patterns..
    private float numeroPacientesDia;

    public HospitalAdapter() { super(); }

    public HospitalAdapter(String descricao, Endereco endereco, Set<Especialidade> especialidades, int quantidadeMedicos,
                           float numeroPacientesDia) {
        super(descricao, endereco, especialidades, quantidadeMedicos);

        this.numeroPacientesDia = numeroPacientesDia;
        this.hospital = new Hospital(descricao, quantidadeMedicos, numeroPacientesDia);
    }

    public float getMediaMedicoPorPaciente() {
        if (this.numeroPacientesDia == 0) // FIXME: Melhorar tratamento e utilizar constantes
            throw new RuntimeException("Número de pacientes por dia não pode ser zero.");

        return this.quantidadeMedicos / this.numeroPacientesDia;
    }

    public float getNumeroPacientesDia() {
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
