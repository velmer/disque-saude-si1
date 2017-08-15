package com.ufcg.si1.controller;


import br.edu.ufcg.Hospital;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ufcg.si1.model.*;
import com.ufcg.si1.service.*;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

/**
 * Created by leandro on 15/08/17.
 */
public class PostoSaudeCtrl {
    UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();

    public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

        Object unidade = unidadeSaudeService.findById(id);

        if(unidade == null){
            return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
        }

        double c = 0.0;
        if (unidade instanceof PostoSaude)
            c = ((PostoSaude) unidade).getAtendentes()
                    / ((PostoSaude) unidade).taxaDiaria();
        else if (unidade instanceof Hospital){
            c = ((Hospital) unidade).getNumeroMedicos()
                    / ((Hospital) unidade).getNumeroPacientesDia();
        }
        return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(c)), HttpStatus.OK);
    }

}
