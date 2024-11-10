package br.com.fiap.fintechapp.model;

public class TipPagamento {

    private int codtippg;
    private String descricao;

    public TipPagamento() {
    }

    public TipPagamento(int codtippg, String descricao) {
        this.codtippg = codtippg;
        this.descricao = descricao;
    }


    public int getCodtippg() {
        return codtippg;
    }

    public void setCodtippg(int codtippg) {
        this.codtippg = codtippg;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
