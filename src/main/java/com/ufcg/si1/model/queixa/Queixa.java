package com.ufcg.si1.model.queixa;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.enumeration.SituacaoQueixa;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;
import exceptions.OperacaoInvalidaException;

import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = QueixaAlimento.class, name = "alimento"),
        @JsonSubTypes.Type(value = QueixaAnimal.class, name = "animal")
})
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Queixa {

    private static final Long ID_DEFAULT = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String comentario;

    @Column
	private String descricao;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private SituacaoQueixa situacao;

    @ManyToOne(cascade = CascadeType.PERSIST)
	private Pessoa solicitante;

	public Queixa() {}

	public Queixa(String comentario, String descricao, Endereco endereco, Pessoa solicitante) {
        this.comentario = comentario;
        this.descricao = descricao;
		this.endereco = endereco;
		this.situacao = SituacaoQueixa.ABERTA;
		this.solicitante = solicitante;
	}

	public void resolverQueixa(String comentario) throws OperacaoInvalidaException {
	    if (!this.situacao.podeSerIniciada())
            throw new OperacaoInvalidaException("Não foi possível alterar a queixa. A mesma já está em andamento.");

        this.situacao = SituacaoQueixa.EM_ANDAMENTO;
        this.comentario = comentario;
    }

	public void fechaQueixa(String comentario) throws OperacaoInvalidaException {
		if (!this.situacao.podeSerFechada())
            throw new OperacaoInvalidaException("Não foi possível alterar a queixa. A mesma já está fechada.");

        this.situacao = SituacaoQueixa.FECHADA;
        this.comentario = comentario;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public SituacaoQueixa getSituacao() {
        return situacao;
    }

    public Pessoa getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Pessoa solicitante) {
        this.solicitante = solicitante;
    }

}
