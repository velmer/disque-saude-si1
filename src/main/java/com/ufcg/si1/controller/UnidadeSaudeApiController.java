package com.ufcg.si1.controller;

import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por receber e tratar requisições das Unidades de Saúde.
 *
 * @author Vélmer Oliveira.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/unidadesaude")
public class UnidadeSaudeApiController {

    private UnidadeSaudeService unidadeSaudeService;

    @Autowired
    public UnidadeSaudeApiController(UnidadeSaudeService unidadeSaudeService) {
        this.unidadeSaudeService = unidadeSaudeService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UnidadeSaude>> listaTodos() {
        return new ResponseEntity<>(this.unidadeSaudeService.listaTodos(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UnidadeSaude> getPorId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(this.unidadeSaudeService.getPorId(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> insere(@RequestBody UnidadeSaude unidadeSaude) {
        return new ResponseEntity<>(this.unidadeSaudeService.salva(unidadeSaude), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> atualiza(@RequestBody UnidadeSaude unidadeSaude) {
        return new ResponseEntity<>(this.unidadeSaudeService.salva(unidadeSaude), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> remove(@RequestParam("id") Long id) {
        return new ResponseEntity<>(this.unidadeSaudeService.removePorId(id), HttpStatus.OK);
    }

}
