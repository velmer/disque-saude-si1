package com.ufcg.si1.repository;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repositório que define as operações da Prefeitura.
 *
 * @author Vélmer Oliveira.
 */
public interface PrefeituraRepository extends CrudRepository<Prefeitura, Long> {

    List<Prefeitura> findAll();

}
