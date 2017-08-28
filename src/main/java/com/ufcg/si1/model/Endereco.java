package com.ufcg.si1.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	private String bairro;

	public Endereco() {}

    public Endereco(String rua, String bairro) {
		this.rua = rua;
		this.bairro = bairro;
	}

	public String getRua() {
		return this.rua;
	}

    public String getBairro() {
        return this.bairro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        return rua.equals(endereco.rua) && bairro.equals(endereco.bairro);
    }

    @Override
    public int hashCode() {
        int result = rua.hashCode();
        result = 31 * result + bairro.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
