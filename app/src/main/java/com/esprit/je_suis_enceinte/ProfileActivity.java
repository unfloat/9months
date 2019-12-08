package com.esprit.je_suis_enceinte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.esprit.je_suis_enceinte.authentification.LoginActivity;

public class ProfileActivity extends AppCompatActivity {


    private String[] Qui = {"Mère","Père","Mère célibataire"};
    private Spinner spQui;

    private String[] sexe = {"Inconnu","Garçon","Fille","Jumeau/Jumelle"};
    private Spinner spsexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        spQui = findViewById(R.id.spinnerQuiProfil);
        spQui.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Qui));
        spQui.setPrompt("Selectionner un choix !");

        spsexe =  findViewById(R.id.spinnerSexeProfil);
        spsexe.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,sexe));


    }


    public void Deconnecter(View view) {

        Intent LoginIntent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(LoginIntent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
