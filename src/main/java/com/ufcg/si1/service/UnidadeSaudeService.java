package com.ufcg.si1.service;

import com.ufcg.si1.model.unidadesaude.Especialidade;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadeSaudeService implements CrudService<UnidadeSaude, Long> {

    private UnidadeSaudeRepository unidadeSaudeRepository;

    @Autowired
    public UnidadeSaudeService(UnidadeSaudeRepository unidadeSaudeRepository) {
        this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    @Override
    public List<UnidadeSaude> listaTodos() {
        return this.unidadeSaudeRepository.findAll();
    }

    @Override
    public UnidadeSaude getPorId(Long id) {
        return this.unidadeSaudeRepository.findOne(id);
    }

    @Override
    public UnidadeSaude salva(UnidadeSaude unidadeSaude) {
        return this.unidadeSaudeRepository.save(unidadeSaude);
    }

    @Override
    public UnidadeSaude atualiza(UnidadeSaude unidadeSaude) {
        return this.unidadeSaudeRepository.exists(unidadeSaude.getId()) ? this.unidadeSaudeRepository.save(unidadeSaude) : null;
    }

    @Override
    public boolean removePorId(Long id) {
        if (this.unidadeSaudeRepository.exists(id)) {
            this.unidadeSaudeRepository.delete(id);
            return true;
        }
        return false;
    }

    public List<UnidadeSaude> getPorEspecialidade(Especialidade especialidade) {
        // FIXME: Quando Especialidade for uma entidade no BD, esse método deve ser substituído por uma query
        List<UnidadeSaude> todasUnidadesSaude = this.listaTodos(),
                unidadesSelecionadas = new ArrayList<>();

        for (UnidadeSaude unidadeSaude : todasUnidadesSaude) {
            if (unidadeSaude.contemEspecialidade(especialidade))
                unidadesSelecionadas.add(unidadeSaude);
        }

        return unidadesSelecionadas;
    }
}
