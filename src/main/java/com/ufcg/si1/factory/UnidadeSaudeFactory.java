package com.ufcg.si1.factory;

import com.ufcg.si1.dto.UnidadeSaudeDTO;
import com.ufcg.si1.model.unidadesaude.Especialidade;
import com.ufcg.si1.model.unidadesaude.HospitalAdapter;
import com.ufcg.si1.model.unidadesaude.PostoSaude;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;

import java.util.Set;

public class UnidadeSaudeFactory {

    public static UnidadeSaude criaUnidadeSaude(String tipo, String descricao, Set<Especialidade> especialidades,
                                    int quantidadeMedicos, float taxaDiariaAtendimento, float numeroPacientesDia) {

        if (tipo.equals("postoSaude")) {
            return new PostoSaude(descricao, especialidades, quantidadeMedicos, taxaDiariaAtendimento);
        } else if (tipo.equals("hospital")) {
            return new HospitalAdapter(descricao, especialidades, quantidadeMedicos, numeroPacientesDia);
        } else {
            throw new RuntimeException();
        }
    }

    public static UnidadeSaude criaUnidadeSaude(UnidadeSaudeDTO unidadeSaudeDTO) {
        return UnidadeSaudeFactory.criaUnidadeSaude(unidadeSaudeDTO.tipo,
                unidadeSaudeDTO.descricao,
                unidadeSaudeDTO.especialidades,
                unidadeSaudeDTO.quantidadeMedicos,
                unidadeSaudeDTO.taxaDiariaAtendimentos,
                unidadeSaudeDTO.numeroPacientesDia);
    }
}
