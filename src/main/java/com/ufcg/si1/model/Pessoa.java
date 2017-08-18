package com.ufcg.si1.model;

import javax.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Embedded
    private Endereco endereco;

	public Pessoa() {}

	public Pessoa(String nome, String email, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

    public Long getId() {
        return id;
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
