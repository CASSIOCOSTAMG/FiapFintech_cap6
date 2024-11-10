package br.com.fiap.fintechapp.model;

import br.com.fiap.fintechapp.util.CriptografiaUtils;

public class Usuario {

    private int codusu;
    private String nomeusu;
    private String  sobrenomeusu;
    private String emailusu;
    private String telefonusu;
    private String celularusu;
    private String senhausu;
    private String login;

    public Usuario(int codusu, String nomeusu, String sobrenomeusu, String emailusu, String telefonusu, String celularusu, String senhausu, String login) {
        this.codusu = codusu;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.emailusu = emailusu;
        this.telefonusu = telefonusu;
        this.celularusu = celularusu;
        this.senhausu = senhausu;
        this.login = login;
    }


    public Usuario(int codusu, String nomeusu, String sobrenomeusu, String emailusu, String telefonusu, String senhausu, String login) {
        this.codusu = codusu;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.emailusu = emailusu;
        this.telefonusu = telefonusu;
        this.senhausu = senhausu;
        this.login = login;
    }


    public Usuario(int codusu, String nomeusu, String sobrenomeusu, String emailusu, String telefonusu,  String login) {
        this.codusu = codusu;
        this.nomeusu = nomeusu;
        this.sobrenomeusu = sobrenomeusu;
        this.emailusu = emailusu;
        this.telefonusu = telefonusu;
        this.senhausu = senhausu;
        this.login = login;
    }



    public Usuario() {
    }

    public int getCodusu() {
        return codusu;
    }

    public void setCodusu(int codusu) {
        this.codusu = codusu;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getSobrenomeusu() {
        return sobrenomeusu;
    }

    public void setSobrenomeusu(String sobrenomeusu) {
        this.sobrenomeusu = sobrenomeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getTelefonusu() {
        return telefonusu;
    }

    public void setTelefonusu(String telefonusu) {
        this.telefonusu = telefonusu;
    }

    public String getCelularusu() {
        return celularusu;
    }

    public void setCelularusu(String celularusu) {
        this.celularusu = celularusu;
    }

    public String getSenhausu() {
        return senhausu;
    }

    public void setSenhausu(String senhausu) {

        try {
            this.senhausu =  CriptografiaUtils.criptografar(senhausu);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Usuario(String login, String senha) {
        super();
        this.login = login;
        setSenhausu(senha);
    }

}

