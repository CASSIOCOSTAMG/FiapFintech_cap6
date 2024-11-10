package br.com.fiap.fintechapp.model;

public class Movimento {

    private int codmov;
    private String descricao;

    public Movimento() {
    }

    public Movimento(int codmov, String descricao) {
        this.codmov = codmov;
        this.descricao = descricao;
    }


    public int getCodmov() {
        return codmov;
    }

    public void setCodmov(int codmov) {
        this.codmov = codmov;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
