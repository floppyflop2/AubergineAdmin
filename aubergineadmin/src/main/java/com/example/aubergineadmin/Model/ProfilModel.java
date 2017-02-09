package com.example.aubergineadmin.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 09/02/2017.
 */

public class ProfilModel {
    private int id;
    private String intitule;
    private List<LogicielModel> logiciels;

    public ProfilModel(int id, String intitule) {
        this.id = id;
        this.intitule = intitule;
        logiciels = new ArrayList<LogicielModel>();
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void ajouterLogiciel(LogicielModel logiciel){
        logiciels.add(logiciel);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
