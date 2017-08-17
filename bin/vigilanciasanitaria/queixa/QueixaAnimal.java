package com.ufcg.si1.model.vigilanciasanitaria.queixa;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

public class QueixaAnimal extends Queixa {

    private String tipoAnimal;

    public QueixaAnimal(String comentario, String descricao, Endereco endereco, Pessoa solicitante,
                        String tipoAnimal) {
        super(comentario, descricao, endereco, solicitante);
        this.tipoAnimal = tipoAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }
}
