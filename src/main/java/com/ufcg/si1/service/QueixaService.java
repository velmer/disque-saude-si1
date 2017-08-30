package com.ufcg.si1.service;

import com.ufcg.si1.enumeration.StatusQueixa;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repository.QueixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueixaService {

    private QueixaRepository queixaRepository;

    @Autowired
    public QueixaService(QueixaRepository queixaRepository) {
        this.queixaRepository = queixaRepository;
    }
	
    public Queixa getPorId(Long id) {
        return this.queixaRepository.findOne(id);
    }

    /**
     * Calcula a proporção entre a quantidade de queixas abertas e a quantidade de queixas
     * fechadas.
     *
     * @return Proporção entre queixas abertas e fechadas.
     */
    public float getProporcaoQueixasAbertasParaFechadas() {
        int quantidadeQueixasAbertas = getQuantidadeQueixasPeloStatus(StatusQueixa.ABERTA),
            quantidadeQueixasFechadas = getQuantidadeQueixasPeloStatus(StatusQueixa.FECHADA);

        float proporcao;

        if (quantidadeQueixasFechadas == 0)
            proporcao = quantidadeQueixasAbertas;
        else
            proporcao =((float) quantidadeQueixasAbertas) / quantidadeQueixasFechadas;

        return proporcao;
    }

    /**
     * Calcula a quantidade de queixas que possui o status especificado.
     *
     * @param statusQueixa Status que deseja-se saber quantas queixas possuem-o.
     * @return Quantidade de queixas que possui o status especificado.
     */
    private int getQuantidadeQueixasPeloStatus(StatusQueixa statusQueixa) {
        List<Queixa> todasQueixas = this.queixaRepository.findAll();
        int quantidadeQueixasDoStatus = 0;

        for (Queixa queixa : todasQueixas) {
            if (queixa.getStatus().equals(statusQueixa))
                quantidadeQueixasDoStatus++;
        }

        return quantidadeQueixasDoStatus;
    }

    public Queixa salva(Queixa queixa) {
        return this.queixaRepository.save(queixa);
    }

    public Queixa atualiza(Queixa queixa) {
        return this.queixaRepository.exists(queixa.getId()) ? this.queixaRepository.save(queixa) : null;
    }

}
