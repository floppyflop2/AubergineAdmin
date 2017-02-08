package com.example.florian.aubergine.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.florian.aubergine.Model.UtilisateurModel;
import com.example.florian.aubergine.MySingleton;
import com.example.florian.aubergine.R;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static String url = "http://fierce-basin-74883.herokuapp.com/api";
    UtilisateurModel mModel;
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



            final TextView mTxtDisplay;

            mTxtDisplay = (TextView) findViewById(R.id.identifiant);
            String url = "http://puu.sh/tTGLK/bd1cefcef0.json";

            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            mTxtDisplay.setText("Response: " + response.toString());
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub

                        }
                    });

// Access the RequestQueue through your singleton class.
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        }
    };



}
