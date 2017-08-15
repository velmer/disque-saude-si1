package com.ufcg.si1.model;

import com.ufcg.si1.enumeration.SituacaoQueixa;
import exceptions.ObjetoInvalidoException;
import exceptions.OperacaoInvalidaException;
import org.springframework.http.ResponseEntity;

public abstract class Queixa {

    private String comentario;
	private String descricao;
    private Endereco endereco;
    private SituacaoQueixa situacao;
	private Pessoa solicitante;

	public Queixa() {}

	public Queixa(String descricao, SituacaoQueixa situacao, String comentario,
                  Pessoa solicitante) {
		this.descricao = descricao;
		this.situacao = situacao;
		this.comentario = comentario;
		this.solicitante = solicitante;
	}

	public String getDescricao() {
		return descricao;
	}

	public SituacaoQueixa getSituacao() {
		return situacao;
	}

	public void fechaQueixa(String comentario) throws OperacaoInvalidaException {
		if (!this.situacao.podeSerFechada())
            throw new OperacaoInvalidaException("Não é possível alterar uma queixa fechada.");

        this.situacao = SituacaoQueixa.FECHADA;
        this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

}
