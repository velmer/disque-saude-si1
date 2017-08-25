package com.ufcg.si1.dto;

import com.ufcg.si1.model.prefeitura.SituacaoPrefeitura;

import javax.validation.constraints.NotNull;

public class PrefeituraDTO {

    public Long id;

    @NotNull(message = "A situação da Prefeitura não pode ser nula.")
    public SituacaoPrefeitura situacao;

}
