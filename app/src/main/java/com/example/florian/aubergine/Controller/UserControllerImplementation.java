package com.example.florian.aubergine.Controller;

import com.example.florian.aubergine.Model.UtilisateurModel;

/**
 * Created by Florian on 06/02/2017.
 */

public class UserControllerImplementation implements UserController{



    @Override
    public UtilisateurModel login() {
        return new UtilisateurModel();
    }
}
