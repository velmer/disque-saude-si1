package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Set;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "postoSaude"),
        @JsonSubTypes.Type(value = HospitalAdapter.class, name = "hospital")
})
public class UnidadeSaude {

    protected String descricao;
    protected Set<Especialidade> especialidades;
    protected int quantidadeMedicos;

    public UnidadeSaude() {}

    public UnidadeSaude(String descricao, Set<Especialidade> especialidades, int quantidadeMedicos) {
        this.descricao = descricao;
        this.especialidades = especialidades;
        this.quantidadeMedicos = quantidadeMedicos;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Set<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public int getQuantidadeMedicos() {
        return this.quantidadeMedicos;
    }

    public void adicionaEspecialidade(Especialidade esp) {
        this.especialidades.add(esp);
    }

}
