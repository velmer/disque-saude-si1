package com.ufcg.si1.repository;

import com.ufcg.si1.model.unidadesaude.Especialidade;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositório que define as operações da Unidade de Saúde.
 *
 * @author Vélmer Oliveira.
 */
public interface UnidadeSaudeRepository extends CrudRepository<UnidadeSaude, Long> {

    List<UnidadeSaude> findAll();

    List<UnidadeSaude> findByEspecialidadesContains(Especialidade especialidade);

    @Query("select u from UnidadeSaude u where u.endereco.bairro = :bairro")
    List<UnidadeSaude> findByBairro(@Param("bairro") String bairro);

}
