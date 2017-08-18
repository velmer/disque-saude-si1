package com.ufcg.si1.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	private String estado;
	private String cidade;

	public Endereco() {}

    public Endereco(String rua, String estado, String cidade) {
		this.rua = rua;
		this.estado = estado;
		this.cidade = cidade;
	}

	public String getRua() {
		return this.rua;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getCidade() {
		return this.cidade;
	}

}
