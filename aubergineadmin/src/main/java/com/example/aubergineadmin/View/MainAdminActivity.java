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


    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.nav_User:
                    setContentView(R.layout.menu_student);

                case R.id.nav_profil:
                    setContentView(R.layout.menu_profil);

                case R.id.nav_logiciel:
                    setContentView(R.layout.menu_logiciel);


            }

        }
    };


}
