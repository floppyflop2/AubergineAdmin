package com.example.aubergineadmin.View;

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
 * Created by Florian on 09/02/2017.
 */

public class ProfilAdd extends AppCompatActivity {

    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    private static Button buttonAddProfil;
    private static Button retourButton;

    public ProfilAdd() {
        buttonAddProfil = (Button) findViewById(R.id.add_profil);
        buttonAddProfil.setOnClickListener(addProfil);

        retourButton = (Button) findViewById(R.id.retourPro);
        retourButton.setOnClickListener(retourL);
    }

    private View.OnClickListener retourL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            setContentView(R.layout.activity_main_admin);
        }
    };

    private View.OnClickListener addProfil = new View.OnClickListener() {
        String intitule = ((TextView) findViewById(R.id.intitule_profiladd)).toString();

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
                                // ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");

                            } else {
                                //((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };


}
