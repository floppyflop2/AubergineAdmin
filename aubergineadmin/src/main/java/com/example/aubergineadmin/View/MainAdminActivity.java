package com.example.aubergineadmin.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aubergineadmin.R;


public class MainAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);


        findViewById(R.id.nav_user).setOnClickListener(onClickUser);

        findViewById(R.id.nav_profil).setOnClickListener(onClickProfil);

        findViewById(R.id.nav_logiciel).setOnClickListener(onClickLogiciel);

    }

    private View.OnClickListener onClickUser = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.menu_user);
        }
    };


    private View.OnClickListener onClickProfil = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.menu_profil);
        }
    };

    private View.OnClickListener onClickLogiciel = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            setContentView(R.layout.menu_logiciel);
        }
    };

}
