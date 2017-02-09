package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

public class MenuProfil extends MainAdminActivity{

    public static String url = "http://fierce-basin-74883.herokuapp.com/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    private View.OnClickListener addProfil = new View.OnClickListener() {
        String profil = ((TextView)findViewById(R.id.titre_profil)).toString();
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

    private View.OnClickListener deleteProfil = new View.OnClickListener() {
        String profil = ((TextView)findViewById(R.id.titre_profil)).toString();
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

    private View.OnClickListener updateProfil = new View.OnClickListener() {
        String profil = ((TextView)findViewById(R.id.titre_profil)).toString();
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
}