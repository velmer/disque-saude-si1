package com.ufcg.si1.model;

import com.ufcg.si1.enumeration.SituacaoQueixa;

public class QueixaAlimento extends Queixa {

    private String estabelecimento;

    public QueixaAlimento(String comentario, String descricao, Endereco endereco, Pessoa solicitante,
                          String estabelecimento) {
        super(comentario, descricao, endereco, solicitante);
        this.estabelecimento = estabelecimento;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }
}
