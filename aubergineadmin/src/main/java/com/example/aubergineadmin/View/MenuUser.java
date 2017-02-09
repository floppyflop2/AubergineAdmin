package com.example.aubergineadmin.View;

import android.os.Bundle;
import android.os.PersistableBundle;
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
import com.example.aubergineadmin.Model.UtilisateurModel;
import com.example.aubergineadmin.MySingleton;
import com.example.aubergineadmin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Florian on 08/02/2017.
 */

public class MenuUser extends AppCompatActivity {


    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    ArrayList<UtilisateurModel> utilisateurs = new ArrayList<>();
    private static Button retourButton;
    private static Button adduserButton;

    public MenuUser() {
        adduserButton = (Button) findViewById(R.id.add_user);
        adduserButton.setOnClickListener(addUser);

        ListView lvUser = (ListView) findViewById(R.id.student_list);
        lvUser.setAdapter(new UserAdapter(this, utilisateurs));
        lvUser.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) listUserListener);
        retourButton = (Button) findViewById(R.id.retourUs);
        retourButton.setOnClickListener(retourL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private View.OnClickListener addUser = new View.OnClickListener() {
        String matricule = ((TextView) findViewById(R.id.usermatriculeadd)).toString();
        String section = ((TextView) findViewById(R.id.usersectionadd)).toString();
        String nom = ((TextView) findViewById(R.id.usernameadd)).toString();

        //on crée une string ac un certain format

        @Override
        public void onClick(View view) {
            setContentView(R.layout.ajout_user);
        }
    };


    private AdapterView.OnItemSelectedListener listUserListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            UtilisateurModel user = (UtilisateurModel) adapterView.getItemAtPosition(position);
            UserDetail uD = new UserDetail(user);
            setContentView(R.layout.user);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    };

    private View.OnClickListener retourL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.activity_main_admin);
        }
    };


}
