package com.ufcg.si1.model;

public class FactoryQueixa {

	public Queixa criaQueixa(long id, String descricao, int situacao, String comentario,
            String nome, String email,
			  String rua, String uf, String cidade){
		return new Queixa(id, descricao, situacao, comentario, nome, email, rua, uf, cidade);
	}
	
}
