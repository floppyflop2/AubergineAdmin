package com.example.aubergineadmin.View;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.aubergineadmin.Controller.SuperControlleur;
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.R;

import org.json.JSONObject;

/**
 * Created by Florian on 09/02/2017.
 */

public class UserAdd extends AppCompatActivity {
    private static Button adduserButton;
    private static Button retourButton;
    private SuperControlleur superControlleur;
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_user);

        this.superControlleur = SuperControlleur.getInstance(this);

        adduserButton = (Button) findViewById(R.id.add_user);
        adduserButton.setOnClickListener(addUser);

        retourButton = (Button) findViewById(R.id.retourUs);
        retourButton.setOnClickListener(retourL);

    }

    private View.OnClickListener addUser = new View.OnClickListener() {
        String matricule = ((TextView) findViewById(R.id.usermatriculeadd)).toString();
        String section = ((TextView) findViewById(R.id.usersectionadd)).toString();
        String nom = ((TextView) findViewById(R.id.usernameadd)).toString();

        //on crée une string ac un certain format

        @Override
        public void onClick(View view) {
            UtilisateurModel usr = new UtilisateurModel(matricule, section, nom);

            superControlleur.insertUser(usr);
        }

    };


    public View.OnClickListener retourL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            Intent intentMaMu = new Intent();
            intentMaMu.setClass(UserAdd.this, MenuUser.class);
            startActivity(intentMaMu);

        }
    };

}
