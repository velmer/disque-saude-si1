package com.ufcg.si1.controller;

import com.ufcg.si1.dto.PrefeituraDTO;
import com.ufcg.si1.factory.PrefeituraFactory;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.service.PrefeituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller responsável por receber e tratar requisições da Prefeitura.
 *
 * @author Vélmer Oliveira
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/prefeituras")
public class PrefeituraApiController {

    private PrefeituraService queixaService;

    @Autowired
    public PrefeituraApiController(PrefeituraService queixaService) {
        this.queixaService = queixaService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Prefeitura>> listaTodos() {
        return new ResponseEntity<>(this.queixaService.listaTodos(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Prefeitura> getPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(this.queixaService.getPorId(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Prefeitura> insere(@Valid @RequestBody PrefeituraDTO prefeituraDTO) {
        Prefeitura prefeitura = PrefeituraFactory.criaPrefeitura(prefeituraDTO);

        return new ResponseEntity<>(this.queixaService.salva(prefeitura), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Prefeitura> atualiza(@Valid @RequestBody PrefeituraDTO prefeituraDTO) {
        Prefeitura prefeitura = PrefeituraFactory.criaPrefeitura(prefeituraDTO);

        return new ResponseEntity<>(this.queixaService.atualiza(prefeitura), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.queixaService.removePorId(id), HttpStatus.OK);
    }

}
