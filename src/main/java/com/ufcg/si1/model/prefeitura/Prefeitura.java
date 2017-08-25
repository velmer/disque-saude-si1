package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enumeration.EficienciaPrefeitura;

import javax.persistence.*;

@Table(name = "TB_PREFEITURA")
@Entity
public class Prefeitura {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private SituacaoPrefeitura situacao;

    public Prefeitura() {}

    public Prefeitura(SituacaoPrefeitura situacao) {
        this.situacao = situacao;
    }

    public EficienciaPrefeitura getEficiencia(float proporcaoQueixasAbertasParaFechadas) {
        return this.situacao.getEficiencia(proporcaoQueixasAbertasParaFechadas);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SituacaoPrefeitura getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPrefeitura situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prefeitura that = (Prefeitura) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Prefeitura{" +
                "id=" + id +
                ", situacao=" + situacao +
                '}';
    }

}
