package com.example.aubergineadmin.View;

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


    public ProfilDetail(ProfilModel profilModel) {
        this.profil=profilModel;
        delProfilButton = (Button) findViewById(R.id.del_profil);
        delProfilButton.setOnClickListener(deleteProfil);

        updateProfilButton = (Button) findViewById(R.id.update_profil);
        updateProfilButton.setOnClickListener(updateProfil);

        findViewById(R.id.retourPro).setOnClickListener(retourL);
        retourButton = (Button) findViewById(R.id.retourLog);
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

    private View.OnClickListener retourL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.activity_main_admin);
        }
    };
}
