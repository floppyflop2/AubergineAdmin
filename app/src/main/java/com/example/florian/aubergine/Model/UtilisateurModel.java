
package com.example.florian.aubergine.Model;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Florian on 06/02/2017.
 */

public class UtilisateurModel implements Serializable {

    private String nom;
    private String prenom;
    private String lieuNaissance;
    private Date dateNaissance;
    private String matricule;
    private String type; // on fait un enum ?


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UtilisateurModel() {

    }

    public UtilisateurModel login(String authentifiant, Date dateN){
        // ici je pense communiquer ahttps://developer.android.com/training/volley/index.htmlc le servlet
        System.out.println("coucou");
        return new UtilisateurModel();

    }
    public UtilisateurModel(String nom, String prenom, String lieuNaissance, Date dateNaissance, String matricule, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieuNaissance = lieuNaissance;
        this.dateNaissance = dateNaissance;
        this.matricule = matricule;
        this.type = type;
    }
}
