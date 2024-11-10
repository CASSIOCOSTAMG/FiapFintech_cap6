package br.com.fiap.fintechapp.model;

public class TipoLanc {

    private int codtipo;
    private String descricao;

    public TipoLanc() {
    }


    public TipoLanc(int codtipo, String descricao) {
        this.codtipo = codtipo;
        this.descricao = descricao;
    }

    public int getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(int codtipo) {
        this.codtipo = codtipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
