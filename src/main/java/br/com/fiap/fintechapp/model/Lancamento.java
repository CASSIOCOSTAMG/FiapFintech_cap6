package br.com.fiap.fintechapp.model;

import java.time.LocalDate;

public class Lancamento {

    private int codlanc ;
    private LocalDate dtlanc ;
    private String descricao ;
    private Double valor;
    private String documento;
    private Movimento movimento ;
    private TipoLanc  tiplanc;
    private Conta conta ;
    private TipPagamento tippagamento ;


    public Lancamento() {
    }

    public Lancamento(int codlanc, LocalDate dtlanc, String descricao, Double valor, String documento) {
        this.codlanc = codlanc;
        this.dtlanc = dtlanc;
        this.descricao = descricao;
        this.valor = valor;
        this.documento = documento;
        this.movimento = movimento;
        this.tiplanc = tiplanc;
        this.conta = conta;
        this.tippagamento = tippagamento;
    }

    public int getCodlanc() {
        return codlanc;
    }

    public void setCodlanc(int codlanc) {
        this.codlanc = codlanc;
    }

    public LocalDate getDtlanc() {
        return dtlanc;
    }

    public void setDtlanc(LocalDate dtlanc) {
        this.dtlanc = dtlanc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public TipoLanc getTiplanc() {
        return tiplanc;
    }

    public void setTiplanc(TipoLanc tiplanc) {
        this.tiplanc = tiplanc;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipPagamento getTippagamento() {
        return tippagamento;
    }

    public void setTippagamento(TipPagamento tippagamento) {
        this.tippagamento = tippagamento;
    }
}
