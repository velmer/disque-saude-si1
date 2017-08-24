package com.ufcg.si1.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class PrefeituraDTO {

    public Long id;

    @NotNull(message = "O tipo da Prefeitura não pode ser nulo.")
    @NotBlank(message = "O tipo da Prefeitura não pode ser branco.")
    @NotEmpty(message = "O tipo da Prefeitura não pode ser vazio.")
    public String tipo;

}
