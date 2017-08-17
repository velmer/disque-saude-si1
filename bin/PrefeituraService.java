package com.ufcg.si1.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefeituraService implements CrudService<PrefeituraService, Long> {

    @Override
    public List<PrefeituraService> listaTodos() {
        return null;
    }

    @Override
    public PrefeituraService getPorId(Long aLong) {
        return null;
    }

    @Override
    public PrefeituraService salva(PrefeituraService prefeituraService) {
        return null;
    }

    @Override
    public PrefeituraService atualiza(PrefeituraService prefeituraService) {
        return null;
    }

    @Override
    public boolean removePorId(Long aLong) {
        return false;
    }
}
