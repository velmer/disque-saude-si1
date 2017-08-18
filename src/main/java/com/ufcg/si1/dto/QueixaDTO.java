package com.ufcg.si1.dto;

import com.ufcg.si1.enumeration.SituacaoQueixa;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

public class QueixaDTO {

    public String tipo;

    public String comentario;

    public String descricao;

    public Endereco endereco;

    public SituacaoQueixa situacao;

    public Pessoa solicitante;

    public String estabelecimento;

    public String tipoAnimal;

}
