package com.ufcg.si1.service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repository.QueixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueixaService implements CrudService<Queixa, Long> {

    private QueixaRepository queixaRepository;

    @Autowired
    public QueixaService(QueixaRepository queixaRepository) {
        this.queixaRepository = queixaRepository;
    }

    @Override
    public List<Queixa> listaTodos() {
        return this.queixaRepository.findAll();
    }

    @Override
    public Queixa getPorId(Long id) {
        return this.queixaRepository.findOne(id);
    }

    @Override
    public Queixa salva(Queixa queixa) {
        return this.queixaRepository.save(queixa);
    }

    @Override
    public Queixa atualiza(Queixa queixa) {
        return this.queixaRepository.exists(queixa.getId()) ? this.queixaRepository.save(queixa) : null;
    }

    @Override
    public boolean removePorId(Long id) {
        if (this.queixaRepository.exists(id)) {
            this.queixaRepository.delete(id);
            return true;
        }
        return false;
    }

}
