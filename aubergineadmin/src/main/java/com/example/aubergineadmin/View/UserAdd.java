package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class UserAdd extends AppCompatActivity {
    private static Button adduserButton;
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adduserButton = (Button) findViewById(R.id.add_user);
        adduserButton.setOnClickListener(addUser);
    }

    private View.OnClickListener addUser = new View.OnClickListener() {
        String matricule = ((TextView)findViewById(R.id.usermatriculeadd)).toString();
        String section = ((TextView)findViewById(R.id.usersectionadd)).toString();
        String nom = ((TextView)findViewById(R.id.usernameadd)).toString();

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
