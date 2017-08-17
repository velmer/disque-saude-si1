package com.ufcg.si1.repository;

import com.ufcg.si1.model.vigilanciasanitaria.VigilanciaSanitaria;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório que define as operações da Vigilância Sanitária.
 *
 * @author Vélmer Oliveira.
 */
public interface VigilanciaSanitariaRepository extends CrudRepository<VigilanciaSanitaria, Long> {

}
