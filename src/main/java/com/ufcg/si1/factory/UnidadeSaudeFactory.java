package com.ufcg.si1.factory;

import com.ufcg.si1.dto.UnidadeSaudeDTO;
import com.ufcg.si1.model.unidadesaude.Especialidade;
import com.ufcg.si1.model.unidadesaude.HospitalAdapter;
import com.ufcg.si1.model.unidadesaude.PostoSaude;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;

import java.util.Set;

public class UnidadeSaudeFactory {

    public static UnidadeSaude criaUnidadeSaude(Long id, String tipo, String descricao, Set<Especialidade> especialidades,
                                    int quantidadeMedicos, float taxaDiariaAtendimento, float numeroPacientesDia) {

        UnidadeSaude unidadeSaudeCriada;

        if (tipo.equals("postoSaude")) {
            unidadeSaudeCriada = new PostoSaude(descricao, especialidades, quantidadeMedicos, taxaDiariaAtendimento);
        } else if (tipo.equals("hospital")) {
            unidadeSaudeCriada = new HospitalAdapter(descricao, especialidades, quantidadeMedicos, numeroPacientesDia);
        } else {
            throw new RuntimeException();
        }

        if (id != null)
            unidadeSaudeCriada.setId(id);

        return unidadeSaudeCriada;
    }

    public static UnidadeSaude criaUnidadeSaude(String tipo, String descricao, Set<Especialidade> especialidades,
                                                int quantidadeMedicos, float taxaDiariaAtendimento, float numeroPacientesDia) {

        return UnidadeSaudeFactory.criaUnidadeSaude(null, tipo, descricao, especialidades, quantidadeMedicos,
                taxaDiariaAtendimento, numeroPacientesDia);
    }

    public static UnidadeSaude criaUnidadeSaude(UnidadeSaudeDTO unidadeSaudeDTO) {
        return UnidadeSaudeFactory.criaUnidadeSaude(unidadeSaudeDTO.id,
                unidadeSaudeDTO.tipo,
                unidadeSaudeDTO.descricao,
                unidadeSaudeDTO.especialidades,
                unidadeSaudeDTO.quantidadeMedicos,
                unidadeSaudeDTO.taxaDiariaAtendimentos,
                unidadeSaudeDTO.numeroPacientesDia);
    }
}
