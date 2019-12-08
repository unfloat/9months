package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.retrofit.RetrofitClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    TextView link_login;

    EditText username, email, password, repeat_password; // This will be a reference to our GitHub username input.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        this.username = (EditText) findViewById(R.id.input_name);  // Link our github user text box.
        this.email = (EditText) findViewById(R.id.input_email);  // Link our github user text box.
        this.password = (EditText) findViewById(R.id.input_password);  // Link our github user text box.
        this.repeat_password = (EditText) findViewById(R.id.input_reEnterPassword);  // Link our github user text box.


        link_login = findViewById(R.id.link_login);


        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });


    }

    public void signup(View view) {
        Call<ResponseBody> call = RetrofitClient.getInstance().getApiInterface().createUser(email.getText().toString().trim(), password.getText().toString().trim(), username.getText().toString().trim());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseBody = response.body().string();
                    Toast.makeText(SignupActivity.this,responseBody, Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Intent LoginIntent = new Intent(SignupActivity.this, SignupDetailActivity.class);
        startActivity(LoginIntent);
    }
}
