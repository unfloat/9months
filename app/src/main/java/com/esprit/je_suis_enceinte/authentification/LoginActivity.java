package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.esprit.je_suis_enceinte.ContainerActivity;
import com.esprit.je_suis_enceinte.MainActivity;
import com.esprit.je_suis_enceinte.MenuActivity;
import com.esprit.je_suis_enceinte.NavigationActivity;
import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.retrofit.RetrofitClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView link_signup;
    EditText username, password; // This will be a reference to our GitHub username input.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.username = (EditText) findViewById(R.id.input_username);  // Link our github user text box.
        this.password = (EditText) findViewById(R.id.input_email);  // Link our github user text box.

        link_signup = findViewById(R.id.link_signup);
        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignupIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(SignupIntent);
            }
        });
    }

    public void login(View view) {
        /*Call<ResponseBody> call = RetrofitClient.getInstance().getApiInterface().createUser(username.getText().toString().trim(), password.getText().toString().trim(), username.getText().toString().trim());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseBody = response.body().string();
                    Toast.makeText(LoginActivity.this,responseBody, Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
*/
       /* Intent loginIntent = new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(loginIntent);*/

        Intent loginIntent = new Intent(LoginActivity.this, NavigationActivity.class);
        startActivity(loginIntent);
    }

}
