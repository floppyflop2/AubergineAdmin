
package com.example.aubergineadmin.Model;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by Florian on 06/02/2017.
 */

public class UtilisateurModel implements Serializable {
    private int id;
    private String nom;
    private String matricule;
    private String section;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getSection() {
        return section;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public UtilisateurModel(int id, String nom, String matricule, String section) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.section = section;
    }
}
