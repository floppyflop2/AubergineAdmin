package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.aubergineadmin.Model.LogicielModel;
import com.example.aubergineadmin.R;

import org.json.JSONObject;

/**
 * Created by Florian on 09/02/2017.
 */

public class LogicielDetail extends AppCompatActivity {
    private static Button delLogicielButton;
    private static Button updateLogicielButton;
    private LogicielModel logicielModel;
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    public LogicielDetail(LogicielModel logicielModel) {
        this.logicielModel=logicielModel;

        delLogicielButton = (Button) findViewById(R.id.del_logiciel);
        delLogicielButton.setOnClickListener(deleteLogiciel);

        updateLogicielButton = (Button) findViewById(R.id.update_logiciel);
        updateLogicielButton.setOnClickListener(updateLogiciel);

        findViewById(R.id.retourLog).setOnClickListener(retourL);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private View.OnClickListener deleteLogiciel = new View.OnClickListener() {
        String logiciel = ((TextView) findViewById(R.id.titre_logiciel)).toString();

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
                                ((TextView) findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                                ((TextView) findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }
    };

    private View.OnClickListener updateLogiciel = new View.OnClickListener() {
        String logiciel = ((TextView) findViewById(R.id.titre_logiciel)).toString();

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
                                ((TextView) findViewById(R.id.erreur)).setText("Service Hors Ligne");
                            } else {
                                ((TextView) findViewById(R.id.erreur)).setText("Matricule inexistant");
                            }

                        }
                    });
        }
    };


    private View.OnClickListener retourL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            setContentView(R.layout.activity_main_admin);
        }
    };

}
