package com.example.aubergineadmin.Model;

/**
 * Created by Florian on 08/02/2017.
 */

public class LogicielModel {

    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LogicielModel(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
