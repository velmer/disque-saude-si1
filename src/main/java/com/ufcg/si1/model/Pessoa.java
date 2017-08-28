package com.ufcg.si1.model;

import javax.persistence.*;

@Table(name = "TB_PESSOA")
@Entity
public class Pessoa {

    @Column
    private String nome;

    @Id
    private String email;

	public Pessoa() {}

	public Pessoa(String nome, String email) {
	    this.nome = nome;
		this.email = email;
	}

    public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return email.equals(pessoa.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
