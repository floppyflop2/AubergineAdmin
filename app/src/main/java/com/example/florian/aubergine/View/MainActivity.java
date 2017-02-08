package com.example.florian.aubergine.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.florian.aubergine.Controller.UserController;
import com.example.florian.aubergine.Controller.UserControllerImplementation;
import com.example.florian.aubergine.Model.DalCommunication;
import com.example.florian.aubergine.Model.UtilisateurModel;
import com.example.florian.aubergine.R;

public class MainActivity extends AppCompatActivity {

    public static String url = "http://fierce-basin-74883.herokuapp.com/api/hello";
    UtilisateurModel mModel;
    DalCommunication dalCommunication = new DalCommunication(url);
    private UserControllerImplementation cController = new UserControllerImplementation(this,dalCommunication);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.loginButton).setOnClickListener(login);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("bla ");

            TextView txtV = (TextView) findViewById(R.id.identifiant);

            String authLogin = txtV.getText().toString();
            UtilisateurModel uM = cController.login(authLogin);
            txtV.setText(uM.getMatricule());

        }
    };



}
