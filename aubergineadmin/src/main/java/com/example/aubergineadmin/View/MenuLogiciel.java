package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
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
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Florian on 08/02/2017.
 */

public class MenuLogiciel extends AppCompatActivity {
    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    private LogicielModel logicielCourant;
    private ArrayList<LogicielModel> logiciels = new ArrayList<>();
    private static Button retourButton;
    private static Button addLogicielButton;

    public MenuLogiciel(){
       addLogicielButton = (Button) findViewById(R.id.add_logiciel);
       addLogicielButton.setOnClickListener(addLogiciel);

        ListView lvLogiciel = (ListView) findViewById(R.id.list_logiciel);
        lvLogiciel.setAdapter(new LogicielAdatpter(this,logiciels));
        lvLogiciel.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) listLogicielListener);

        retourButton = (Button)findViewById(R.id.retourLog);
        retourButton.setOnClickListener(retourL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    private View.OnClickListener addLogiciel = new View.OnClickListener() {
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
                          //      ((TextView) findViewById(R.id.matricule)).setText("Service Hors Ligne");
                            } else {
                          //      ((TextView) findViewById(R.id.matricule)).setText("Matricule inexistant");
                            }

                        }
                    });
        }

    };


    private AdapterView.OnItemSelectedListener listLogicielListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            LogicielModel log = (LogicielModel) adapterView.getItemAtPosition(position);
            LogicielDetail logD = new LogicielDetail(log);
            setContentView(R.layout.logiciel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    };


    private View.OnClickListener retourL = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            setContentView(R.layout.activity_main_admin);
        }
    };

}
