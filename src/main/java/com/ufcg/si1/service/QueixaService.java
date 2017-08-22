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

    public float getProporcaoQueixas() {
        List<Queixa> todasQueixas = listaTodos();

        int quantidadeQueixasAbertas = 0, quantidadeQueixasFechadas = 0;

        for(Queixa queixa : todasQueixas) {
            if (queixa.estaAberta())
                quantidadeQueixasAbertas++;
            else if (queixa.estaFechada())
                quantidadeQueixasFechadas++;
        }

        // Todo: Adicionar tratamento para divisão por 0

        return ((float) quantidadeQueixasAbertas) / quantidadeQueixasFechadas;
    }

    @Override
    public Queixa salva(Queixa queixa) {
        if (queixa.temSolicitantePersistido())
            queixa.transformaParaMerge();

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
