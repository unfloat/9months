package com.esprit.je_suis_enceinte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esprit.je_suis_enceinte.authentification.LoginActivity;
import com.esprit.je_suis_enceinte.authentification.SignupActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    Button btn_registrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login= findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        btn_registrer = findViewById(R.id.btn_registrer);
        btn_registrer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Signup = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(Signup);
            }
        });


    }
}
