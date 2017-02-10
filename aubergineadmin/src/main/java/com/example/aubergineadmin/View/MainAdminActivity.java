package com.example.aubergineadmin.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aubergineadmin.R;


public class MainAdminActivity extends AppCompatActivity {
    private MenuLogiciel menuLogiciel;
    private MenuProfil menuProfil;
    private MenuUser menuUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);


        findViewById(R.id.nav_user).setOnClickListener(onClickUser);

        findViewById(R.id.nav_profil).setOnClickListener(onClickProfil);

        findViewById(R.id.nav_logiciel).setOnClickListener(onClickLogiciel);
        this.menuLogiciel = new MenuLogiciel();
        this.menuProfil = new MenuProfil();
        this.menuUser = new MenuUser();

    }

    private View.OnClickListener onClickUser = new View.OnClickListener() {
        @Override
        public void onClick(View view) {



            Intent intentMaMu = new Intent();
            intentMaMu.setClass(MainAdminActivity.this, MenuUser.class);
            startActivity(intentMaMu);


        }
    };


    private View.OnClickListener onClickProfil = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intentMaPro = new Intent();
            intentMaPro.setClass(MainAdminActivity.this, MenuProfil.class);
            startActivity(intentMaPro);

        }
    };



    private View.OnClickListener onClickLogiciel = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("logiciel");


            Intent intentMaML = new Intent();
            intentMaML.setClass(MainAdminActivity.this, MenuLogiciel.class);
            startActivity(intentMaML);




        }
    };

}
