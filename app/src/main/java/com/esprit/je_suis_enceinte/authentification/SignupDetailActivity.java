package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.entities.User;

public class SignupDetailActivity extends AppCompatActivity {

    private String[] Qui = {"Mère","Père","Mère célibataire"};
    private Spinner spQui;

    private String[] sexe = {"Inconnu","Garçon","Fille","Jumeau/Jumelle"};
    private Spinner spsexe;
    Button btn_termine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_detail);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        User u = (User) bundle.getSerializable("user");

        spQui = findViewById(R.id.spinnerQui);
        spQui.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Qui));
        spQui.setPrompt("Selectionner un choix !");

        spsexe =  findViewById(R.id.spinnerSexe);
        spsexe.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,sexe));


        btn_termine = findViewById(R.id.btn_termine);
        btn_termine.setOnClickListener(v -> {

            TextView textView = (TextView)spQui.getSelectedView();
            String result = textView.getText().toString();
            u.setGenreuser(result);

            TextView textView1 = (TextView)spsexe.getSelectedView();
            String result1 = textView1.getText().toString();
            u.setSexebebe(result1);
            signupDetail(u);
        });





    }

    public void signupDetail(User user) {
        Intent intent1=new Intent(SignupDetailActivity.this, TermeActivity.class);
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("user", user);
        intent1.putExtras(bundle1);
        startActivity(intent1);
    }
}
