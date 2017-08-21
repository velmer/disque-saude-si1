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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        if (!rua.equals(endereco.rua)) return false;
        if (!estado.equals(endereco.estado)) return false;
        return cidade.equals(endereco.cidade);
    }

    @Override
    public int hashCode() {
        int result = rua.hashCode();
        result = 31 * result + estado.hashCode();
        result = 31 * result + cidade.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
