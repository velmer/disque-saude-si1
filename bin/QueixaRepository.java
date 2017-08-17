package com.ufcg.si1.repository;

import com.ufcg.si1.model.vigilanciasanitaria.queixa.Queixa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repositório que define as operações da Queixa.
 *
 * @author Vélmer Oliveira.
 */
public interface QueixaRepository extends CrudRepository<Queixa, Long> {

    List<Queixa> findAll();

}
