package com.ufcg.si1.model;

import com.ufcg.si1.enumeration.SituacaoQueixa;

public class QueixaAlimento extends Queixa {

    private Endereco endereco;
    private String estabelecimento;

    public QueixaAlimento(String descricao, SituacaoQueixa situacao, String comentario,
                          Pessoa solicitante, String estabelecimento, Endereco endereco) {
        super(descricao, situacao, comentario, solicitante);
        this.endereco = endereco;
        this.estabelecimento = estabelecimento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }
}
