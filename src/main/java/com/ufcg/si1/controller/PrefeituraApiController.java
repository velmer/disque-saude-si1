package com.ufcg.si1.controller;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.SituacaoPrefeitura;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.QueixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável por receber e tratar requisições da Prefeitura.
 *
 * @author Vélmer Oliveira
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/prefeituras")
public class PrefeituraApiController {

    private PrefeituraService prefeituraService;
    private QueixaService queixaService;

    @Autowired
    public PrefeituraApiController(PrefeituraService prefeituraService, QueixaService queixaService) {
        this.prefeituraService = prefeituraService;
        this.queixaService = queixaService;
    }

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Prefeitura> getPrefeitura() {
		Prefeitura prefeitura = this.prefeituraService.getPrefeitura();
		
        return new ResponseEntity<>(prefeitura, HttpStatus.OK);
    }

    @RequestMapping(value = "/eficiencia", method = RequestMethod.GET)
    public ResponseEntity<EficienciaPrefeitura> getEficiencia() {
        Prefeitura prefeitura = this.prefeituraService.getPrefeitura();
        float proporcaoQueixasAbertasParaFechadas = this.queixaService.getProporcaoQueixasAbertasParaFechadas();

        return new ResponseEntity<>(prefeitura.getEficiencia(proporcaoQueixasAbertasParaFechadas), HttpStatus.OK);
    }

    @RequestMapping(value = "/situacao", method = RequestMethod.POST)
    public ResponseEntity<Prefeitura> alteraSituacao(@RequestBody SituacaoPrefeitura situacao) {
        Prefeitura prefeitura = this.prefeituraService.getPrefeitura();
        prefeitura.setSituacao(situacao);

        return new ResponseEntity<>(this.prefeituraService.atualiza(prefeitura), HttpStatus.OK);
    }

}
