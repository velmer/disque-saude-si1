package com.ufcg.si1.util;

/**
 * Classe que declara os caminhos - utilizados na URL para acesso ao servidor - a fim de
 * modularização e reutilização.
 */
public final class Paths {

    /**
     * Para evitar confusões, vamos deixar o construtor privado.
     */
    private Paths() {}

    public static final String POR_ID = "/{id}";

    public static final String LOGIN = "/login";

    public static final String PREFEITURA = "/prefeituras";
    public static final String EFICIENCIA = "/eficiencia";
    public static final String SITUACAO = "/situacao";
    public static final String EFICIENCIA_PREFEITURA = Paths.PREFEITURA + Paths.EFICIENCIA;
    public static final String SITUACAO_PREFEITURA = Paths.PREFEITURA + Paths.SITUACAO;

    public static final String UNIDADE_SAUDE = "/unidadesaude";
    public static final String ESPECIALIDADE = "/especialidade";
    public static final String BAIRRO = "/bairro";
    public static final String UNIDADE_SAUDE_POR_ESPECIALIDADE = Paths.UNIDADE_SAUDE + Paths.ESPECIALIDADE;
    public static final String UNIDADE_SAUDE_POR_BAIRRO = Paths.UNIDADE_SAUDE + Paths.BAIRRO;
    public static final String MEDIA = "/media";
    public static final String MEDIA_POR_ID = Paths.POR_ID + Paths.MEDIA;
    public static final String MEDIA_UNIDADE_SAUDE = Paths.UNIDADE_SAUDE + Paths.MEDIA_POR_ID;

    public static final String QUEIXA = "/queixas";
    public static final String QUEIXA_POR_ID = Paths.QUEIXA + Paths.POR_ID;

}
