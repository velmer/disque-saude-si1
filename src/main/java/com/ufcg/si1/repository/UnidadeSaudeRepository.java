package com.ufcg.si1.repository;

import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório que define as operações da Unidade de Saúde.
 *
 * @author Vélmer Oliveira.
 */
public interface UnidadeSaudeRepository extends CrudRepository<UnidadeSaude, Long> {
    
}
