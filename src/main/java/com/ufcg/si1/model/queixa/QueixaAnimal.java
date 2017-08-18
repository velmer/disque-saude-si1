package com.ufcg.si1.model.queixa;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class QueixaAnimal extends Queixa {

    @Column
    private String tipoAnimal;

    public QueixaAnimal() {}

    public QueixaAnimal(String comentario, String descricao, Endereco endereco, Pessoa solicitante,
                        String tipoAnimal) {
        super(comentario, descricao, endereco, solicitante);
        this.tipoAnimal = tipoAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }
}
