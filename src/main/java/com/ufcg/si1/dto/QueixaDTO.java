package com.ufcg.si1.dto;

import com.ufcg.si1.enumeration.StatusQueixa;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class QueixaDTO {

    public Long id;

    @NotNull(message = "O tipo da Queixa não pode ser nulo.")
    @NotBlank(message = "O tipo da Queixa não pode ser branco.")
    @NotEmpty(message = "O tipo da Queixa não pode ser vazio.")
    public String tipo;

    public String comentario;

    public String descricao;

    @NotNull(message = "O endereço da Queixa não pode ser nulo.")
    public Endereco endereco;

    @Enumerated
    public StatusQueixa status;

    @NotNull(message = "O solicitante da Queixa não pode ser nulo.")
    public Pessoa solicitante;

    public String estabelecimento;

    public String tipoAnimal;

}
