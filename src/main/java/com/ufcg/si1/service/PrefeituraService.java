package com.ufcg.si1.service;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.repository.PrefeituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefeituraService implements CrudService<Prefeitura, Long> {

    private PrefeituraRepository prefeituraRepository;

    @Autowired
    public PrefeituraService(PrefeituraRepository prefeituraRepository) {
        this.prefeituraRepository = prefeituraRepository;
    }

    @Override
    public List<Prefeitura> listaTodos() {
        return this.prefeituraRepository.findAll();
    }

    @Override
    public Prefeitura getPorId(Long id) {
        return this.prefeituraRepository.findOne(id);
    }

    @Override
    public Prefeitura salva(Prefeitura prefeitura) {
        return this.prefeituraRepository.save(prefeitura);
    }

    @Override
    public Prefeitura atualiza(Prefeitura prefeitura) {
        if (!this.prefeituraRepository.exists(prefeitura.getId()))
            return null;

        Prefeitura prefeituraPersistida = getPorId(prefeitura.getId());

        return this.prefeituraRepository.exists(prefeitura.getId()) ? this.prefeituraRepository.save(prefeitura) : null;
    }

    @Override
    public boolean removePorId(Long id) {
        if (this.prefeituraRepository.exists(id)) {
            this.prefeituraRepository.delete(id);
            return true;
        }
        return false;
    }
}
