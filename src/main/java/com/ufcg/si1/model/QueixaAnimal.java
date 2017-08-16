package com.ufcg.si1.model;

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
