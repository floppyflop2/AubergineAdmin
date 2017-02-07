package com.example.florian.aubergine.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.florian.aubergine.Controller.UserController;
import com.example.florian.aubergine.Model.UtilisateurModel;
import com.example.florian.aubergine.R;

public class MainActivity extends AppCompatActivity {

    UtilisateurModel mModel;
    UserController cController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void login(){
       findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               System.out.println("bla ");

               TextView txtV = (TextView)findViewById(R.id.identifiant) ;
               txtV.setText("bla");
               String authLogin = txtV.getText().toString();
               UtilisateurModel uM = cController.login("", null);

           }


       });

    }
}
