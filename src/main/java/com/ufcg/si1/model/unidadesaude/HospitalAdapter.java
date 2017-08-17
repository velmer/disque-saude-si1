package com.ufcg.si1.model.unidadesaude;

import br.edu.ufcg.Hospital;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class HospitalAdapter extends UnidadeSaude {

    // FIXME: What in the hell should I put here?
    private Hospital hospital;

    public HospitalAdapter() { super(); }

    public HospitalAdapter(String descricao, Set<Especialidade> especialidades, int quantidadeMedicos,
                           int quantidadePacientesDia) {
        super(descricao, especialidades, quantidadeMedicos);

        this.hospital = new Hospital(descricao, quantidadeMedicos, quantidadePacientesDia);
    }

    public int getQuantidadePacientesDia() {
        return (int) this.hospital.getNumeroPacientesDia();
    }
}
