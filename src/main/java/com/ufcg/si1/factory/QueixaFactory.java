package com.ufcg.si1.factory;

import com.ufcg.si1.dto.QueixaDTO;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAlimento;
import com.ufcg.si1.model.queixa.QueixaAnimal;

public class QueixaFactory {

    public static Queixa criaQueixa(String tipo, String comentario, String descricao, Endereco endereco,
            Pessoa solicitante, String estabelecimento, String tipoAnimal) {

        if (tipo.equals("alimento")) {
            return new QueixaAlimento(comentario, descricao, endereco, solicitante, estabelecimento);
        } else if (tipo.equals("animal")) {
            return new QueixaAnimal(comentario, descricao, endereco, solicitante, tipoAnimal);
        } else {
            throw new RuntimeException();
        }
    }

    public static Queixa criaQueixa(QueixaDTO queixaDTO) {
        return QueixaFactory.criaQueixa(queixaDTO.tipo,
                queixaDTO.comentario,
                queixaDTO.descricao,
                queixaDTO.endereco,
                queixaDTO.solicitante,
                queixaDTO.estabelecimento,
                queixaDTO.tipoAnimal);
    }
}
