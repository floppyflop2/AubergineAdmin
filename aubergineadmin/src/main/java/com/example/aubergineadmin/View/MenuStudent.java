package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.aubergineadmin.MySingleton;
import com.example.aubergineadmin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Florian on 08/02/2017.
 */

public class MenuStudent extends AppCompatActivity {


    public static String url = "http://fierce-basin-74883.herokuapp.com/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);


    }

    private View.OnClickListener userAdd = new View.OnClickListener() {
        String matricule = ((TextView)findViewById(R.id.matricule)).toString();
        String section = ((TextView)findViewById(R.id.section)).toString();
        String nom = ((TextView)findViewById(R.id.nom)).toString();

        //on crée une string ac un certain format

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
                                ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                                ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };


    private View.OnClickListener userDel = new View.OnClickListener() {
        String matricule = ((TextView)findViewById(R.id.matricule)).toString();
        String section = ((TextView)findViewById(R.id.section)).toString();
        String nom = ((TextView)findViewById(R.id.nom)).toString();

        //on crée une string ac un certain format

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
                                ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                                ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };


    private View.OnClickListener userUpdate = new View.OnClickListener() {
        String matricule = ((TextView)findViewById(R.id.matricule)).toString();
        String section = ((TextView)findViewById(R.id.section)).toString();
        String nom = ((TextView)findViewById(R.id.nom)).toString();

        //on crée une string ac un certain format

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
                                ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                                ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };

/*
    public void send() {

        final TextView erreur = (TextView) findViewById(R.id.erreur);
        final TextView matricule = (TextView) findViewById(R.id.matricule);
        //String url = "https://puu.sh/tTPpB/4a50a9429f.json";
        //String url = "https://puu.sh/";
        String url = "http://fierce-basin-74883.herokuapp.com/api/login/";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url + matricule.getText(), null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        setContentView(R.layout.feuille_de_login);
                        final TextView feuilleDeLoginsTW = (TextView) findViewById(R.id.logins);
                        try {
                            JSONArray logiciels = response.getJSONArray("logiciels");
                            String feuilleDeLogins = "";
                            for (int i = 0; i < logiciels.length(); i++) {
                                JSONObject logiciel = logiciels.getJSONObject(i);
                                feuilleDeLogins += logiciel.get("nom") + " :\n";
                                feuilleDeLogins += "login : " + logiciel.get("login") + "\n";
                                feuilleDeLogins += "mdp : " + logiciel.get("mdp") + "\n\n";
                            }


                            feuilleDeLoginsTW.setText(feuilleDeLogins);
                        } catch (JSONException e) {
                            erreur.setText("erreur interne, JSON mal construit");
                            System.out.println(e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        System.out.print(error);
                        matricule.setText("");
                        if (error.networkResponse == null) {
                            erreur.setText("Service Hors Ligne");
                        } else {
                            erreur.setText("Matricule inexistant");
                        }
                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
    }
*/

}
