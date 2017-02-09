package com.example.florian.aubergine.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.florian.app.R;
import com.example.florian.aubergine.MySingleton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    //UtilisateurModel mModel;
    //DalCommunication dalCommunication = new DalCommunication(url);
    //private UserControllerImplementation cController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.loginButton).setOnClickListener(login);
        //this.cController=new UserControllerImplementation(this,dalCommunication,Volley.newRequestQueue(this));

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    private View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("bla ");



            final TextView erreur = (TextView) findViewById(R.id.erreur);
            final TextView matricule = (TextView) findViewById(R.id.matricule);
            //String url = "https://puu.sh/tTPpB/4a50a9429f.json";
            //String url = "https://puu.sh/";
            String url= "http://fierce-basin-74883.herokuapp.com/api/login/";
            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url+matricule.getText(), null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            setContentView(R.layout.feuille_de_login);
                            final TextView feuilleDeLoginsTW = (TextView) findViewById(R.id.logins);
                            try{
                                JSONArray logiciels = response.getJSONArray("logiciels");
                                String feuilleDeLogins= "";
                                for(int i= 0; i<logiciels.length(); i++){
                                    JSONObject logiciel =logiciels.getJSONObject(i);
                                    feuilleDeLogins +=logiciel.get("nom")+" :\n";
                                    feuilleDeLogins +="login : "+logiciel.get("login")+"\n";
                                    feuilleDeLogins +="mdp : "+logiciel.get("mdp")+"\n\n";
                                }


                                feuilleDeLoginsTW.setText(feuilleDeLogins);
                            }catch (JSONException e){
                                erreur.setText("erreur interne, JSON mal construit");
                                System.out.println(e);
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {

                            System.out.print(error);
                            matricule.setText("");
                            if(error.networkResponse==null){
                                erreur.setText("Service Hors Ligne");
                            }else {
                                erreur.setText("Matricule inexistant");
                            }
                        }
                    });

// Access the RequestQueue through your singleton class.
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        }
    };



}
