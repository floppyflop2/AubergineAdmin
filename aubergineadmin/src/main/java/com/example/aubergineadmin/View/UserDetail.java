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
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.R;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Florian on 09/02/2017.
 */

public class UserDetail extends AppCompatActivity{
    private static Button deluserButton;
    private static Button updateuserButton;
    private UtilisateurModel utilisateurModel;
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";

    public UserDetail(UtilisateurModel utilisateurModel){
        this.utilisateurModel=utilisateurModel;
        TextView tvMatricule = (TextView) findViewById(R.id.usermatricule);
        TextView tvName = (TextView) findViewById(R.id.username);
        TextView tvSection = (TextView) findViewById(R.id.usersection);

        tvMatricule.setText(utilisateurModel.getMatricule());
        tvName.setText(utilisateurModel.getNom());
        tvSection.setText(utilisateurModel.getSection());

        deluserButton.setOnClickListener(deleteUser);
        updateuserButton.setOnClickListener(updateUser);


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        deluserButton = (Button) findViewById(R.id.del_user);
        deluserButton.setOnClickListener(deleteUser);

        updateuserButton = (Button) findViewById(R.id.update_user);
        updateuserButton.setOnClickListener(updateUser);

    }

    private View.OnClickListener deleteUser = new View.OnClickListener() {

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
                            //    ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                          //      ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };


    private View.OnClickListener updateUser = new View.OnClickListener() {

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
                              //  ((TextView)findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                             //   ((TextView)findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };


}
