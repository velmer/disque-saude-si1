package com.ufcg.si1.model.queixa;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.enumeration.StatusQueixa;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;
import exceptions.OpcaoNaoExistenteException;
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
    protected Long id;

    @Column
    protected String comentario;

    @Column
    protected String descricao;

    @Embedded
    protected Endereco endereco;

    @Enumerated(EnumType.STRING)
    protected StatusQueixa status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Pessoa solicitante;

	public Queixa() {}

	public Queixa(String comentario, String descricao, Endereco endereco, Pessoa solicitante) {
        this.comentario = comentario;
        this.descricao = descricao;
		this.endereco = endereco;
		this.status = StatusQueixa.ABERTA;
		this.solicitante = solicitante;
	}

    /**
     * Verifica se o solicitante já foi persistido no BD.
     *
     * @return {@code true} caso o solicitante já tenha sido persistido, {@code false}
     * caso contrário.
     */
    public boolean temSolicitantePersistido() {
        return this.solicitante.getId() != null;
    }

    /**
     * Transforma o objeto a fim do mesmo ser "merged" no BD. Este método garante que
     * ao salvar a entidade, o método chamado pelo EntityManager será o "merge()".
     */
    public void transformaParaMerge() {
	    this.id = ID_DEFAULT;
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

    public StatusQueixa getStatus() {
        return status;
    }

    public void setStatus(StatusQueixa status) {
        this.status = status;
    }

    public Pessoa getSolicitante() {
        return solicitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Queixa queixa = (Queixa) o;

        return id.equals(queixa.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public abstract String toString();
}
