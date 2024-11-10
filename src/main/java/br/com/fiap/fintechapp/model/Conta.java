package br.com.fiap.fintechapp.model;

public class Conta {

    private int codconta;
    private String descricaoconta;

    public Conta() {
    }


    public Conta(int codconta, String descricaoconta) {
        this.codconta = codconta;
        this.descricaoconta = descricaoconta;
    }


    public int getCodconta() {
        return codconta;
    }

    public void setCodconta(int codconta) {
        this.codconta = codconta;
    }

    public String getDescricaoconta() {
        return descricaoconta;
    }

    public void setDescricaoconta(String descricaoconta) {
        this.descricaoconta = descricaoconta;
    }
}
