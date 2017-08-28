package com.ufcg.si1.service;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.unidadesaude.Especialidade;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadeSaudeService {

    private UnidadeSaudeRepository unidadeSaudeRepository;

    @Autowired
    public UnidadeSaudeService(UnidadeSaudeRepository unidadeSaudeRepository) {
        this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    public UnidadeSaude getPorId(Long id) {
        return this.unidadeSaudeRepository.findOne(id);
    }

    public UnidadeSaude salva(UnidadeSaude unidadeSaude) {
        return this.unidadeSaudeRepository.save(unidadeSaude);
    }

    public UnidadeSaude atualiza(UnidadeSaude unidadeSaude) {
        return this.unidadeSaudeRepository.exists(unidadeSaude.getId()) ? this.unidadeSaudeRepository.save(unidadeSaude) : null;
    }

    public List<UnidadeSaude> getPorEspecialidade(Especialidade especialidade) {
        return this.unidadeSaudeRepository.findByEspecialidadesContains(especialidade);
    }

    public List<UnidadeSaude> getPorBairro(String bairro) {
        return this.unidadeSaudeRepository.findByBairro(bairro);
    }
}
