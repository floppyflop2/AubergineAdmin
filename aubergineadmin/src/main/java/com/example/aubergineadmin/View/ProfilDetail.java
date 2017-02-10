package com.example.aubergineadmin.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.aubergineadmin.Model.ProfilModel;
import com.example.aubergineadmin.R;

import org.json.JSONObject;

/**
 * Created by Florian on 09/02/2017.
 */

public class ProfilDetail extends AppCompatActivity {

    private static Button delProfilButton;
    private static Button updateProfilButton;
    private static Button retourButton;
    private ProfilModel profil;
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";

    public ProfilDetail() {
        super();
    }

    public ProfilDetail(ProfilModel profilModel) {
        this.profil=profilModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        delProfilButton = (Button) findViewById(R.id.del_profil);
        delProfilButton.setOnClickListener(deleteProfil);

        updateProfilButton = (Button) findViewById(R.id.update_profil);
        updateProfilButton.setOnClickListener(updateProfil);

        findViewById(R.id.retourPro).setOnClickListener(retourL);
        retourButton = (Button) findViewById(R.id.retourPro);
        retourButton.setOnClickListener(retourL);
    }

    private View.OnClickListener deleteProfil = new View.OnClickListener() {
        String profil = ((TextView) findViewById(R.id.titre_profil)).toString();

        @Override
        public void onClick(View view) {
            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.print(error);
                            if (error.networkResponse == null) {
                                //  ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                                //   ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }
    };

    private View.OnClickListener updateProfil = new View.OnClickListener() {
        String profil = ((TextView) findViewById(R.id.titre_profil)).toString();

        @Override
        public void onClick(View view) {
            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.print(error);
                            if (error.networkResponse == null) {
                                //  ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                                // ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }
    };

    public View.OnClickListener retourL = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            Intent intentMaML = new Intent();
            intentMaML.setClass(ProfilDetail.this, MenuProfil.class);
            startActivity(intentMaML);

        }
    };
}
