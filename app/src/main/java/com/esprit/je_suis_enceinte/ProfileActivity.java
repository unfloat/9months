package com.esprit.je_suis_enceinte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.esprit.je_suis_enceinte.authentification.LoginActivity;
import com.esprit.je_suis_enceinte.bd.SessionHandler;
import com.esprit.je_suis_enceinte.entities.User;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {

    private SessionHandler session;


    private String[] Qui = {"Mère","Père","Mère célibataire"};
    private Spinner spQui;

    private String[] sexe = {"Inconnu","Garçon","Fille","Jumeau/Jumelle"};
    private Spinner spsexe;

    EditText nomprofile,emailrofile,datetermeprofil;
    ImageView imageprofil;
    final Calendar myCalendar = Calendar.getInstance();
    private ProgressDialog pDialog;
    Button btn_EnregistrerProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();

        nomprofile = findViewById(R.id.nomprofile);
        nomprofile.setText(user.getNom());

        emailrofile = findViewById(R.id.emailrofile);
        emailrofile.setText(user.getEmail());

        datetermeprofil = findViewById(R.id.datetermeprofil);
        datetermeprofil.setInputType(InputType.TYPE_NULL);
        datetermeprofil.setText(user.getDateterme());
        final DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        };

        datetermeprofil.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            new DatePickerDialog(ProfileActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        imageprofil = findViewById(R.id.imageprofil);
        spQui = findViewById(R.id.spinnerQuiProfil);
        spQui.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Qui));
        if(user.getGenreuser().equals("Père")){spQui.setSelection(1);
        imageprofil.setImageDrawable(getResources().getDrawable(R.drawable.profileiconh));}
        else if(user.getGenreuser().equals("Mère")){spQui.setSelection(0);}
        else{spQui.setSelection(2);}

        spsexe =  findViewById(R.id.spinnerSexeProfil);
        spsexe.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,sexe));
        if(user.getSexebebe().equals("Inconnu")){spsexe.setSelection(0);}
        else if(user.getSexebebe().equals("Garçon")){spsexe.setSelection(1);}
        else if(user.getSexebebe().equals("Fille")){spsexe.setSelection(2);}
        else{spsexe.setSelection(3);}


    }


    public void Deconnecter(View view) {

        Intent LoginIntent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(LoginIntent);
    }
    private void displayLoader() {
        pDialog = new ProgressDialog(ProfileActivity.this);
        pDialog.setMessage("Logging In.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void loadDashboard() {

        Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
