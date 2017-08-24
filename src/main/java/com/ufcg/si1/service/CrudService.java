package com.ufcg.si1.service;

import java.io.Serializable;
import java.util.List;

/**
 * Interface que define os métodos básicos que devem ser implementados por um Service.
 *
 * @author Vélmer Oliveira
 */
public interface CrudService<T, ID extends Serializable> {

    List<T> listaTodos();

    T getPorId(ID id);

    T salva(T t);

    T atualiza(T t);

    boolean removePorId(ID id);

}