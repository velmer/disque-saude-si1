package com.ufcg.si1.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
    private String estado;

	public Endereco() {}

    public Endereco(String rua, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
        this.estado = estado;
	}

	public String getRua() {
		return this.rua;
	}

    public String getBairro() {
        return this.bairro;
    }

	public String getCidade() {
		return this.cidade;
	}

    public String getEstado() {
        return this.estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        return rua.equals(endereco.rua)
                && bairro.equals(endereco.bairro)
                && cidade.equals(endereco.cidade)
                && estado.equals(endereco.estado);
    }

    @Override
    public int hashCode() {
        int result = rua.hashCode();
        result = 31 * result + bairro.hashCode();
        result = 31 * result + cidade.hashCode();
        result = 31 * result + estado.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
