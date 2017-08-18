package com.ufcg.si1.model.unidadesaude;

import br.edu.ufcg.Hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class HospitalAdapter extends UnidadeSaude {

    // FIXME: What in the hell should I put here?
    @Transient
    private Hospital hospital;

    @Column
    private float numeroPacientesDia;

    public HospitalAdapter() { super(); }

    public HospitalAdapter(String descricao, Set<Especialidade> especialidades, int quantidadeMedicos,
                           float numeroPacientesDia) {
        super(descricao, especialidades, quantidadeMedicos);

        this.numeroPacientesDia = numeroPacientesDia;
        this.hospital = new Hospital(descricao, quantidadeMedicos, numeroPacientesDia);
    }

    public float getNumeroPacientesDia() {
        return this.numeroPacientesDia;
    }
}
