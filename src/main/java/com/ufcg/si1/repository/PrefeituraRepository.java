package com.ufcg.si1.repository;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório que define as operações da Prefeitura.
 *
 * @author Vélmer Oliveira.
 */
public interface PrefeituraRepository extends CrudRepository<Prefeitura, Long> {
}
