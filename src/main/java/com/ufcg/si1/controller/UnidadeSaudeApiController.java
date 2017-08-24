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
import javax.validation.constraints.NotNull;
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
    public ResponseEntity<List<UnidadeSaude>> getPorEspecialidade(@RequestParam("especialidade") Especialidade especialidade) {
        List<UnidadeSaude> unidadesSelecionadas = this.unidadeSaudeService.getPorEspecialidade(especialidade);

        if (unidadesSelecionadas.isEmpty())
            return new ResponseEntity<>(unidadesSelecionadas, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(unidadesSelecionadas, HttpStatus.OK);
    }

    @RequestMapping(value = "/bairro", method = RequestMethod.GET)
    public ResponseEntity<List<UnidadeSaude>> getPorBairro(@NotNull @RequestParam("bairro") String bairro) {
        List<UnidadeSaude> unidadesSelecionadas = this.unidadeSaudeService.getPorBairro(bairro);

        if (unidadesSelecionadas.isEmpty())
            return new ResponseEntity<>(unidadesSelecionadas, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(unidadesSelecionadas, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/media", method = RequestMethod.GET)
    public ResponseEntity<UnidadeSaudeDTO> getMediaMedicoPorPaciente(@PathVariable("id") Long id) {
        UnidadeSaude unidadeSaude = this.unidadeSaudeService.getPorId(id);
        UnidadeSaudeDTO unidadeSaudeDTO = new UnidadeSaudeDTO();

        if (unidadeSaude == null)
            return new ResponseEntity<>(unidadeSaudeDTO, HttpStatus.NOT_FOUND);

        unidadeSaudeDTO.mediaMedicoPorPaciente = unidadeSaude.calculaMediaMedicoPorPaciente();
        return new ResponseEntity<>(unidadeSaudeDTO, HttpStatus.OK);
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
