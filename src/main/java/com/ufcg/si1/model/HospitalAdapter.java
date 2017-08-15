package com.ufcg.si1.model;

import br.edu.ufcg.Hospital;

import java.util.List;
import java.util.Set;

public class HospitalAdapter extends UnidadeSaude {

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
