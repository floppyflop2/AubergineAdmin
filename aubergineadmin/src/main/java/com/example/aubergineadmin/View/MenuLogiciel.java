package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.aubergineadmin.Model.LogicielModel;
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.R;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Florian on 08/02/2017.
 */

public class MenuLogiciel extends MainAdminActivity {
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    public LogicielModel logicielCourant ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private View.OnClickListener addLogiciel = new View.OnClickListener() {
        String logiciel = ((TextView)findViewById(R.id.titre_logiciel)).toString();

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

    private View.OnClickListener deleteLogiciel = new View.OnClickListener() {
        String logiciel = ((TextView)findViewById(R.id.titre_logiciel)).toString();
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

    private View.OnClickListener updateLogiciel = new View.OnClickListener() {
        String logiciel = ((TextView)findViewById(R.id.titre_logiciel)).toString();
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
