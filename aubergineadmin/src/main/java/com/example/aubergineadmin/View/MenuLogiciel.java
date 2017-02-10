package com.example.aubergineadmin.View;

import android.content.Intent;
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
import com.example.aubergineadmin.Controller.SuperControlleur;
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
    public static Button retourButton;

    //public static Button addLogicielButton;

    public MenuLogiciel(){
        super();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_logiciel);

        Button addLogicielButton = (Button)findViewById(R.id.add_logiciel);
        addLogicielButton.setOnClickListener(addLogiciel);

        ListView lvLogiciel = (ListView) findViewById(R.id.list_logiciel);
        lvLogiciel.setAdapter(new LogicielAdatpter(this,logiciels));
        lvLogiciel.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) listLogicielListener);



        MenuLogiciel.retourButton = (Button)findViewById(R.id.retourLog);
        retourButton.setOnClickListener(retourL);
    }



    private View.OnClickListener addLogiciel = new View.OnClickListener() {


        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            Intent intentMLAL = new Intent();
            intentMLAL.setClass(MenuLogiciel.this, LogicielAdd.class);
            startActivity(intentMLAL);

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


    public View.OnClickListener retourL = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            System.out.println("bonjour");
            Intent intentMaML = new Intent();
            intentMaML.setClass(MenuLogiciel.this, MainAdminActivity.class);
            startActivity(intentMaML);

        }
    };

}
