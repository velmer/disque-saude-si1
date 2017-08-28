package com.ufcg.si1.service;

import com.ufcg.si1.factory.PrefeituraFactory;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.SituacaoPrefeituraNormal;
import com.ufcg.si1.repository.PrefeituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefeituraService {

    private PrefeituraRepository prefeituraRepository;

    @Autowired
    public PrefeituraService(PrefeituraRepository prefeituraRepository) {
        this.prefeituraRepository = prefeituraRepository;
    }

    public Prefeitura getPrefeitura() {
        Prefeitura prefeitura = this.prefeituraRepository.getPrefeitura();

		if (prefeitura == null)
            prefeitura = inserePrefeitura();

        return prefeitura;
    }

    private Prefeitura inserePrefeitura() {
        Prefeitura prefeitura = PrefeituraFactory.criaPrefeitura(new SituacaoPrefeituraNormal());

        return this.prefeituraRepository.save(prefeitura);
    }

    public Prefeitura atualiza(Prefeitura prefeitura) {
        return this.prefeituraRepository.save(prefeitura);
    }


}
