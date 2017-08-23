package com.ufcg.si1.model.unidadesaude;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.Endereco;

import javax.persistence.*;
import java.util.Set;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "postoSaude"),
        @JsonSubTypes.Type(value = HospitalAdapter.class, name = "hospital")
})
@Table(name = "TB_UNIDADE_SAUDE")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UnidadeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column
    protected String descricao;

    @Embedded
    protected Endereco endereco;

    @ElementCollection
    protected Set<Especialidade> especialidades;

    @Column
    protected int quantidadeMedicos;

    public UnidadeSaude() {}

    public UnidadeSaude(String descricao, Endereco endereco, Set<Especialidade> especialidades, int quantidadeMedicos) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.especialidades = especialidades;
        this.quantidadeMedicos = quantidadeMedicos;
    }

    public float getMediaMedicoPorPaciente() {
        if (getTaxaPacientesPorDia() == 0)  // FIXME: Melhorar tratamento e utilizar constantes
            throw new RuntimeException("Taxa de pacientes por dia não pode ser zero.");

        return this.quantidadeMedicos / getTaxaPacientesPorDia();
    }

    public abstract float getTaxaPacientesPorDia();

    public boolean adicionaEspecialidade(Especialidade esp) {
        return this.especialidades.add(esp);
    }

    public boolean contemEspecialidade(Especialidade esp) {
        return  this.especialidades.contains(esp);
    }

    public boolean pertenceAoBairro(Endereco endereco) {
        return this.endereco.getBairro().equals(endereco.getBairro());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Set<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public int getQuantidadeMedicos() {
        return this.quantidadeMedicos;
    }

    @Override
    public abstract String toString();

}
