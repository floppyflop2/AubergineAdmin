package com.example.florian.aubergine.Controller;

import com.example.florian.aubergine.Model.UtilisateurModel;

import java.util.Date;

/**
 * Created by Florian on 06/02/2017.
 */

public class UserControllerImplementation implements UserController{



    @Override
    public UtilisateurModel login(String authentifiant, Date dateN){
        // ici je pense communiquer ac le servlet
        System.out.println("coucou");
        return new UtilisateurModel();

    }
}
