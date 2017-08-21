package com.ufcg.si1.model.queixa;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "TB_QUEIXA_ALIMENTO")
@Entity
public class QueixaAlimento extends Queixa {

    @Column
    private String estabelecimento;

    public QueixaAlimento() {}

    public QueixaAlimento(String comentario, String descricao, Endereco endereco, Pessoa solicitante,
                          String estabelecimento) {
        super(comentario, descricao, endereco, solicitante);
        this.estabelecimento = estabelecimento;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    @Override
    public String toString() {
        return "QueixaAlimento{" +
                "estabelecimento='" + estabelecimento + '\'' +
                ", id=" + id +
                ", comentario='" + comentario + '\'' +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", status=" + status +
                ", solicitante=" + solicitante +
                '}';
    }
}
