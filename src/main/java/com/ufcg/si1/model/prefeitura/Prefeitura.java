package com.ufcg.si1.model.prefeitura;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.enumeration.EficienciaPrefeitura;

import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PrefeituraNormal.class, name = "normal"),
        @JsonSubTypes.Type(value = PrefeituraExtra.class, name = "extra"),
        @JsonSubTypes.Type(value = PrefeituraCaos.class, name = "caos")
})
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Prefeitura {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column
    protected float limiteEficienciaBaixa;

    @Column
    protected float limiteEficienciaRegular;

    public Prefeitura(float limiteEficienciaBaixa, float limiteEficienciaRegular) {
        this.limiteEficienciaBaixa = limiteEficienciaBaixa;
        this.limiteEficienciaRegular = limiteEficienciaRegular;
    }

    /**
     * Retorna a eficiência da Prefeitura de acordo com o seu estado e a proporção entre
     * queixas abertas e fechadas.
     *
     * @param proporcaoQueixas Proporção entre queixas abertas e fechadas.
     * @return EficienciaPrefeitura Enum que indica qual a eficiência da prefeitura.
     */
    public EficienciaPrefeitura getEficiencia(float proporcaoQueixas) {
        if (proporcaoQueixas > limiteEficienciaBaixa)
            return EficienciaPrefeitura.BAIXA;
        else if (proporcaoQueixas > limiteEficienciaRegular)
            return EficienciaPrefeitura.REGULAR;
        else
            return EficienciaPrefeitura.ALTA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLimiteEficienciaBaixa() {
        return limiteEficienciaBaixa;
    }

    public float getLimiteEficienciaRegular() {
        return limiteEficienciaRegular;
    }
}
