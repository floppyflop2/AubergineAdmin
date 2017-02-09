package com.example.aubergineadmin.Model;

/**
 * Created by babwin on 09-02-17.
 */

public class LoginModel {
    private LogicielModel logiciel;
    private UtilisateurModel utilisateurModel;
    private String motDePasse;
    private String login;

    public LoginModel(LogicielModel logiciel, UtilisateurModel utilisateurModel, String motDePasse, String login) {
        this.logiciel = logiciel;
        this.utilisateurModel = utilisateurModel;
        this.motDePasse = motDePasse;
        this.login = login;
    }

    public LogicielModel getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(LogicielModel logiciel) {
        this.logiciel = logiciel;
    }

    public UtilisateurModel getUtilisateurModel() {
        return utilisateurModel;
    }

    public void setUtilisateurModel(UtilisateurModel utilisateurModel) {
        this.utilisateurModel = utilisateurModel;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
