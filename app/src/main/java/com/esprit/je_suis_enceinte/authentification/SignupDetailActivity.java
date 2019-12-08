package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.esprit.je_suis_enceinte.R;

public class SignupDetailActivity extends AppCompatActivity {

    private String[] Qui = {"Mère","Père","Mère célibataire"};
    private Spinner spQui;

    private String[] sexe = {"Inconnu","Garçon","Fille","Jumeau/Jumelle"};
    private Spinner spsexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_detail);

        spQui = findViewById(R.id.spinnerQui);
        spQui.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Qui));
        spQui.setPrompt("Selectionner un choix !");

        spsexe =  findViewById(R.id.spinnerSexe);
        spsexe.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,sexe));


    }

    public void signupDetail(View view) {

        Intent LoginIntent = new Intent(SignupDetailActivity.this, TermeActivity.class);
        startActivity(LoginIntent);
    }
}
