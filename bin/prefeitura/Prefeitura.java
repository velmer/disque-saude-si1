package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;
import com.ufcg.si1.model.unidadesaude.UnidadeSaude;
import com.ufcg.si1.model.vigilanciasanitaria.VigilanciaSanitaria;

import java.util.List;

public class Prefeitura {

    private SituacaoPrefeitura situacaoPrefeitura;
    private List<UnidadeSaude> unidadesSaude;
    private VigilanciaSanitaria vigilanciaSanitaria;

    public Prefeitura() {}

    public Prefeitura(SituacaoPrefeitura situacaoPrefeitura, List<UnidadeSaude> unidadesSaude,
                      VigilanciaSanitaria vigilanciaSanitaria) {
        this.situacaoPrefeitura = situacaoPrefeitura;
        this.unidadesSaude = unidadesSaude;
        this.vigilanciaSanitaria = vigilanciaSanitaria;
    }

    public EficienciaPrefeitura getEficiencia(float proporcaoQueixasAbertas) {
        return situacaoPrefeitura.getEficiencia(proporcaoQueixasAbertas);
    }

    public void setSituacaoPrefeitura(SituacaoPrefeitura situacaoPrefeitura) {
        this.situacaoPrefeitura = situacaoPrefeitura;
    }

    public List<UnidadeSaude> getUnidadesSaude() {
        return unidadesSaude;
    }

    public VigilanciaSanitaria getVigilanciaSanitaria() {
        return vigilanciaSanitaria;
    }
}
