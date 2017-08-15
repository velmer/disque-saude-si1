package com.ufcg.si1.model;

public class Pessoa {

    protected String nome;
    protected String email;
    protected Endereco endereco;

	public Pessoa() {}

	public Pessoa(String nome, String email, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

    public Endereco getEndereco() {
        return endereco;
    }

}
