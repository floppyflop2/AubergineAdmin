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
import com.example.aubergineadmin.R;

import org.json.JSONObject;

/**
 * Created by Florian on 08/02/2017.
 */

public class MenuProfil extends AppCompatActivity{

    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    private static Button retourButton;
    private static   Button addProfilButton;

    public MenuProfil() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_profil);
        addProfilButton = (Button) findViewById(R.id.add_profil);
        addProfilButton.setOnClickListener(addProfil);
        retourButton = (Button) findViewById(R.id.retourPro);
        retourButton.setOnClickListener(retourL);

    }



    private View.OnClickListener addProfil = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intentMaAdP = new Intent();
            intentMaAdP.setClass(MenuProfil.this, ProfilAdd.class);
            startActivity(intentMaAdP);
        }
    };


    public View.OnClickListener retourL = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            Intent intentMaPro = new Intent();
            intentMaPro.setClass(MenuProfil.this, MainAdminActivity.class);
            startActivity(intentMaPro);

        }
    };
}
