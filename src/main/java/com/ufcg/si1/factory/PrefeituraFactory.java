package com.ufcg.si1.factory;

import com.ufcg.si1.dto.PrefeituraDTO;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.PrefeituraCaos;
import com.ufcg.si1.model.prefeitura.PrefeituraExtra;
import com.ufcg.si1.model.prefeitura.PrefeituraNormal;

public class PrefeituraFactory {

    public static Prefeitura criaPrefeitura(Long id, String tipo) {
        Prefeitura prefeituraCriada;

        if (tipo.equals("normal")) {
            prefeituraCriada = new PrefeituraNormal();
        } else if (tipo.equals("extra")) {
            prefeituraCriada = new PrefeituraExtra();
        } else if (tipo.equals("caos")) {
            prefeituraCriada = new PrefeituraCaos();
        } else {
            throw new RuntimeException();
        }

        if (id != null)
            prefeituraCriada.setId(id);

        return prefeituraCriada;
    }

    public static Prefeitura criaPrefeitura(String tipo) {
        return PrefeituraFactory.criaPrefeitura(null, tipo);
    }

    public static Prefeitura criaPrefeitura(PrefeituraDTO prefeituraDTO) {
        return PrefeituraFactory.criaPrefeitura(prefeituraDTO.id, prefeituraDTO.tipo);
    }

}
