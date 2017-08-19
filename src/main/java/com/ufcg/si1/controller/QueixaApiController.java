package com.ufcg.si1.controller;

import com.ufcg.si1.dto.QueixaDTO;
import com.ufcg.si1.factory.QueixaFactory;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
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
@RequestMapping(value = "/queixas")
public class QueixaApiController {

    private QueixaService queixaService;

    @Autowired
    public QueixaApiController(QueixaService queixaService) {
        this.queixaService = queixaService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Queixa>> listaTodos() {
        return new ResponseEntity<>(this.queixaService.listaTodos(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Queixa> getPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(this.queixaService.getPorId(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Queixa> insere(@Valid @RequestBody QueixaDTO queixaDTO) {
        Queixa queixa = QueixaFactory.criaQueixa(queixaDTO);

        if (queixa.temSolicitantePersistido())
            queixa.transformaParaMerge();

        return new ResponseEntity<>(this.queixaService.salva(queixa), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Queixa> atualiza(@Valid @RequestBody QueixaDTO queixaDTO) {
        Queixa queixa = QueixaFactory.criaQueixa(queixaDTO);

        return new ResponseEntity<>(this.queixaService.atualiza(queixa), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.queixaService.removePorId(id), HttpStatus.OK);
    }

}
