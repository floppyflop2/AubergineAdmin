package com.example.aubergineadmin.Model;

/**
 * Created by Florian on 08/02/2017.
 */

public class LogicielModel {

    private String id;
    private String nom;

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LogicielModel(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
