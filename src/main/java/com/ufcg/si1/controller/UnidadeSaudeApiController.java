package com.ufcg.si1.controller;

import com.ufcg.si1.dto.UnidadeSaudeDTO;
import com.ufcg.si1.factory.UnidadeSaudeFactory;
import com.ufcg.si1.model.unidadesaude.Especialidade;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UnidadeSaude> getPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.unidadeSaudeService.getPorId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/especialidade", method = RequestMethod.GET)
    public ResponseEntity<List<UnidadeSaude>> getPorEspecialidade(@RequestParam("especialidade") String nomeEspecialidade) {
        List<UnidadeSaude> todasUnidadesSaude = this.unidadeSaudeService.listaTodos(),
                unidadesSelecionadas = new ArrayList<>();

        for (UnidadeSaude unidadeSaude : todasUnidadesSaude) {
            if (unidadeSaude.contemEspecialidade(nomeEspecialidade))
                unidadesSelecionadas.add(unidadeSaude);
        }

        if (unidadesSelecionadas.isEmpty())
            return new ResponseEntity<>(unidadesSelecionadas, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(unidadesSelecionadas, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> insere(@Valid @RequestBody UnidadeSaudeDTO unidadeSaudeDTO) {
        UnidadeSaude unidadeSaude = UnidadeSaudeFactory.criaUnidadeSaude(unidadeSaudeDTO);

        return new ResponseEntity<>(this.unidadeSaudeService.salva(unidadeSaude), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UnidadeSaude> atualiza(@Valid @RequestBody UnidadeSaudeDTO unidadeSaudeDTO) {
        UnidadeSaude unidadeSaude = UnidadeSaudeFactory.criaUnidadeSaude(unidadeSaudeDTO);

        return new ResponseEntity<>(this.unidadeSaudeService.atualiza(unidadeSaude), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.unidadeSaudeService.removePorId(id), HttpStatus.OK);
    }

}
