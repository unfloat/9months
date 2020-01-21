package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.esprit.je_suis_enceinte.NavigationActivity;
import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.bd.SessionHandler;
import com.esprit.je_suis_enceinte.entities.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SignupActivity extends AppCompatActivity {

    TextView link_login;
    EditText etUsername, etEmail, etPassword, etConfirmPassword;
    Button btn_signup;


    private static final String KEY_EMPTY = "";

    private String email;
    private String password;
    private String confirmPassword;
    private String nom;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        this.etUsername = findViewById(R.id.etUsername);
        this.etEmail = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);
        this.etConfirmPassword = findViewById(R.id.etConfirmPassword);

        link_login = findViewById(R.id.link_login);
        link_login.setOnClickListener(v -> {
            Intent LoginIntent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(LoginIntent);
            finish();
        });

        btn_signup = findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(v -> {
            nom = etUsername.getText().toString().toLowerCase().trim();
            password = etPassword.getText().toString().trim();
            confirmPassword = etConfirmPassword.getText().toString().trim();
            email = etEmail.getText().toString().trim();
            if (validateInputs()) {
                registerUser(new User(nom,email,password));
            }
        });
    }





    private void registerUser(User user) {
        Intent intent=new Intent(SignupActivity.this, SignupDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        intent.putExtras(bundle);
        startActivity(intent);
        }
    


    private boolean validateInputs() {
        if (KEY_EMPTY.equals(email)) {
            etEmail.setError("Email cannot be empty");
            etEmail.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(nom)) {
            etUsername.setError("nom cannot be empty");
            etUsername.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirm Password cannot be empty");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password and Confirm Password does not match");
            etConfirmPassword.requestFocus();
            return false;
        }
        return true;
    }
}
