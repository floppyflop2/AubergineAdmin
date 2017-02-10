
package com.example.aubergineadmin.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Florian on 06/02/2017.
 */

public class UtilisateurModel implements Serializable {
    private int id;
    private String nom;
    private String matricule;
    private String email;
    private String prenom;
    private String dateDeNaissance; // AAAA-MM-JJ
    private String type;
    private List<LoginModel> logins;
    private List<ProfilModel> profils;
    private String section;

    public List<LoginModel> getLogins() {
        return logins;
    }

    public List<ProfilModel> getProfils() {
        return profils;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterLogin (LoginModel login){
        this.logins.add(login);
    }

    public void ajouterProfil (ProfilModel profil){
        this.profils.add(profil);
    }

    public String getMatricule() {
        return matricule;
    }

    public String getEmail(){ return email;}

    public String getPrenom () { return this.prenom;   }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setEmail (String email) { this.email = email;   }

    public void setDateDeNaissance (String dateDeNaissance){
        this.dateDeNaissance=dateDeNaissance;
    }

    public void setDateDeNaissance (int annee, int mois, int jour){
        this.dateDeNaissance=annee+"-"+mois+"-"+jour;
    }

    public void setPrenom (String prenom) { this.prenom = prenom;   }

    public UtilisateurModel(String nom, String matricule, String section) {
        this.nom = nom;
        this.matricule = matricule;
        this.section = section;
    }

    public UtilisateurModel(int id, String nom, String prenom, String matricule, String email , String dateDeNaissance, String type) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.email = email;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.logins=new ArrayList<LoginModel>();
        this.profils= new ArrayList<ProfilModel>();
        this.type=type;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
