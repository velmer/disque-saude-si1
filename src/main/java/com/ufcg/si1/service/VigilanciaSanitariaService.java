package com.ufcg.si1.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VigilanciaSanitariaService implements CrudService<VigilanciaSanitariaService, Long> {

    @Override
    public List<VigilanciaSanitariaService> listaTodos() {
        return null;
    }

    @Override
    public VigilanciaSanitariaService getPorId(Long aLong) {
        return null;
    }

    @Override
    public VigilanciaSanitariaService salva(VigilanciaSanitariaService vigilanciaSanitariaService) {
        return null;
    }

    @Override
    public VigilanciaSanitariaService atualiza(VigilanciaSanitariaService vigilanciaSanitariaService) {
        return null;
    }

    @Override
    public boolean removePorId(Long aLong) {
        return false;
    }
}
