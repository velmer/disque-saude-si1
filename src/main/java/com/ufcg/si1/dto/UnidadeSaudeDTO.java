package com.ufcg.si1.dto;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.unidadesaude.Especialidade;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class UnidadeSaudeDTO {

    public Long id;

    @NotNull(message = "O tipo da Unidade de Saúde não pode ser nulo.")
    @NotBlank(message = "O tipo da Unidade de Saúde não pode ser branco.")
    @NotEmpty(message = "O tipo da Unidade de Saúde não pode ser vazio.")
    public String tipo;

    @NotNull(message = "A descrição da Unidade de Saúde não pode ser nula.")
    public String descricao;

    @NotNull(message = "O endereço da Unidade de Saúde não pode ser nulo.")
    public Endereco endereco;

    @NotNull(message = "A lista de especialidades da Unidade de Saúde não pode ser nula.")
    public Set<Especialidade> especialidades;

    @Min(value = 0, message = "Uma Unidade de Saúde não pode possuir uma quantidade negativa de médicos.")
    public int quantidadeMedicos;

    @Min(value = 0, message = "Uma Unidade de Saúde não pode possuir uma taxa diária de atendimentos negativa.")
    public float taxaDiariaAtendimentos;

    @Min(value = 0, message = "Uma Unidade de Saúde não pode possuir o número de pacientes por dia negativo.")
    public float numeroPacientesDia;
}
