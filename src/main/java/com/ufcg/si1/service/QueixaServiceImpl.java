package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.FactoryQueixa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

    private static final AtomicLong counter = new AtomicLong();

    private List<Queixa> queixas;
    
    private FactoryQueixa novaQueixa;


    public QueixaServiceImpl(){
    	queixas = new ArrayList<Queixa>();
    	novaQueixa = new FactoryQueixa();
    }

    private List<Queixa> adicionaQueixas() {
        inicializaQueixas();
        return queixas;
    }

    public List<Queixa> findAllQueixas() {
        return queixas;
    }

    public void saveQueixa(Queixa queixa) {
        queixa.setId(counter.incrementAndGet());
        queixas.add(queixa);
    }

    public void updateQueixa(Queixa queixa) {
        int index = queixas.indexOf(queixa);
        queixas.set(index, queixa);
    }

    public void deleteQueixaById(long id) {

        for (Iterator<Queixa> iterator = queixas.iterator(); iterator.hasNext(); ) {
            Queixa q = iterator.next();
            if (q.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    //este metodo nunca eh chamado, mas se precisar estah aqui
    public int size() {
        return queixas.size();
    }

    @Override
    public Iterator<Queixa> getIterator() {
        return queixas.iterator();
    }

    public void deleteAllUsers() {
        queixas.clear();
    }

    public Queixa findById(long id) {
        for (Queixa queixa : queixas) {
            if (queixa.getId() == id) {
                return queixa;
            }
        }
        return null;
    }
    
    private void inicializaQueixas() {
		queixas.add(novaQueixa.criaQueixa(counter.incrementAndGet(), "Passei mal com uma coxinha",
                Queixa.FECHADA, "", "Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "Recife"));


        queixas.add(novaQueixa.criaQueixa(counter.incrementAndGet(),
                "Bacalhau estragado, passamos mal!", Queixa.FECHADA, "",
                "Ailton Sousa", "ailton@gmail.com", "rua dos bobos", "PB",
                "Joao Pessoa"));

        queixas.add(novaQueixa.criaQueixa(counter.incrementAndGet(), "Nossa rua estah muito suja", Queixa.FECHADA, "",
                "Jose Silva", "jose@gmail.com", "rua dos tolos", "PE", "Recife"));


        queixas.add(novaQueixa.criaQueixa(counter.incrementAndGet(), "iluminacao horrivel, muitos assaltos", Queixa.FECHADA, "",
                "Ailton Sousa", "ailton@gmail.com", "rua dos bobos", "PB",
                "Joao Pessoa"));
	}



}
