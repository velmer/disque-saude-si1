package com.ufcg.si1.factory;

import com.ufcg.si1.dto.QueixaDTO;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAlimento;
import com.ufcg.si1.model.queixa.QueixaAnimal;

public class QueixaFactory {

    public static Queixa criaQueixa(Long id, String tipo, String comentario, String descricao, Endereco endereco,
            Pessoa solicitante, String estabelecimento, String tipoAnimal) {

        Queixa queixaCriada;

        if (tipo.equals("alimento")) {
            queixaCriada = new QueixaAlimento(comentario, descricao, endereco, solicitante, estabelecimento);
        } else if (tipo.equals("animal")) {
            queixaCriada = new QueixaAnimal(comentario, descricao, endereco, solicitante, tipoAnimal);
        } else {
            throw new RuntimeException();
        }

        if (id != null)
            queixaCriada.setId(id);

        return queixaCriada;
    }

    public static Queixa criaQueixa(String tipo, String comentario, String descricao, Endereco endereco,
                                    Pessoa solicitante, String estabelecimento, String tipoAnimal) {

        return QueixaFactory.criaQueixa(null, tipo, comentario, descricao, endereco, solicitante,
                estabelecimento, tipoAnimal);
    }

    public static Queixa criaQueixa(QueixaDTO queixaDTO) {
        return QueixaFactory.criaQueixa(queixaDTO.id,
                queixaDTO.tipo,
                queixaDTO.comentario,
                queixaDTO.descricao,
                queixaDTO.endereco,
                queixaDTO.solicitante,
                queixaDTO.estabelecimento,
                queixaDTO.tipoAnimal);
    }
}
