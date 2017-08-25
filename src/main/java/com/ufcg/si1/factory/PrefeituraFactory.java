package com.ufcg.si1.factory;

import com.ufcg.si1.dto.PrefeituraDTO;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.SituacaoPrefeitura;

public class PrefeituraFactory {

    public static Prefeitura criaPrefeitura(Long id, SituacaoPrefeitura situacao) {
        Prefeitura prefeituraCriada = new Prefeitura(situacao);

        if (id != null)
            prefeituraCriada.setId(id);

        return prefeituraCriada;
    }

    public static Prefeitura criaPrefeitura(SituacaoPrefeitura situacao) {
        return PrefeituraFactory.criaPrefeitura(null, situacao);
    }

    public static Prefeitura criaPrefeitura(PrefeituraDTO prefeituraDTO) {
        return PrefeituraFactory.criaPrefeitura(prefeituraDTO.id, prefeituraDTO.situacao);
    }

}
