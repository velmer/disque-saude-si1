package com.ufcg.si1.controller;

import com.ufcg.si1.dto.QueixaDTO;
import com.ufcg.si1.factory.QueixaFactory;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.util.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller responsável por receber e tratar requisições de Queixas.
 *
 * @author Vélmer Oliveira
 */
@RestController
@CrossOrigin
@RequestMapping(value = Paths.QUEIXA)
public class QueixaApiController {

    private QueixaService queixaService;

    @Autowired
    public QueixaApiController(QueixaService queixaService) {
        this.queixaService = queixaService;
    }

    @RequestMapping(value = Paths.POR_ID, method = RequestMethod.GET)
    public ResponseEntity<Queixa> getPorId(@PathVariable("id") Long id) {
        Queixa queixa = this.queixaService.getPorId(id);
        HttpStatus status;

        status = queixa == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(queixa, status);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Queixa> insere(@Valid @RequestBody QueixaDTO queixaDTO) {
        Queixa queixa = QueixaFactory.criaQueixa(queixaDTO);

        return new ResponseEntity<>(this.queixaService.salva(queixa), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Queixa> atualiza(@Valid @RequestBody QueixaDTO queixaDTO) {
        Queixa queixa = QueixaFactory.criaQueixa(queixaDTO);

        if (queixaDTO.status != null)
            queixa.setStatus(queixaDTO.status);

        return new ResponseEntity<>(this.queixaService.atualiza(queixa), HttpStatus.OK);
    }

}
