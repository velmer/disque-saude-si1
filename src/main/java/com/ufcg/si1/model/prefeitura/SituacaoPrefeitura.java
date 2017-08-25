package com.ufcg.si1.model.prefeitura;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.enumeration.EficienciaPrefeitura;

import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SituacaoPrefeituraNormal.class, name = "normal"),
        @JsonSubTypes.Type(value = SituacaoPrefeituraExtra.class, name = "extra"),
        @JsonSubTypes.Type(value = SituacaoPrefeituraCaos.class, name = "caos")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SituacaoPrefeitura {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column
    protected float limiteEficienciaBaixa;

    @Column
    protected float limiteEficienciaRegular;

    public SituacaoPrefeitura() {}

    public SituacaoPrefeitura(float limiteEficienciaBaixa, float limiteEficienciaRegular) {
        this.limiteEficienciaBaixa = limiteEficienciaBaixa;
        this.limiteEficienciaRegular = limiteEficienciaRegular;
    }

    /**
     * Retorna a eficiência da Prefeitura de acordo com o seu estado e a proporção entre
     * queixas abertas e fechadas.
     *
     * @param proporcaoQueixasAbertasParaFechadas Proporção entre queixas abertas e fechadas.
     * @return EficienciaPrefeitura Enum que indica qual a eficiência da prefeitura.
     */
    public EficienciaPrefeitura getEficiencia(float proporcaoQueixasAbertasParaFechadas) {
        if (proporcaoQueixasAbertasParaFechadas > limiteEficienciaBaixa)
            return EficienciaPrefeitura.BAIXA;
        else if (proporcaoQueixasAbertasParaFechadas > limiteEficienciaRegular)
            return EficienciaPrefeitura.REGULAR;
        else
            return EficienciaPrefeitura.ALTA;
    }

    @Override
    public abstract String toString();
}
