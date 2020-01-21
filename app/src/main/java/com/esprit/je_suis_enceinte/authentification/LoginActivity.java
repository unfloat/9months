package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.esprit.je_suis_enceinte.NavigationActivity;
import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.bd.MySingleton;
import com.esprit.je_suis_enceinte.bd.SessionHandler;
import com.esprit.je_suis_enceinte.entities.User;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    TextView link_signup;
    EditText input_email, input_password;
    Button btn_login;

    private RequestQueue queue;

    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";

    private ProgressDialog pDialog;
    private SessionHandler session;

    private String email;
    private String mdp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new SessionHandler(getApplicationContext());
        setContentView(R.layout.activity_login);

        input_email =  findViewById(R.id.input_email);
        input_password =  findViewById(R.id.input_password);
        btn_login = findViewById(R.id.btn_login);

        link_signup = findViewById(R.id.link_signup);
        link_signup.setOnClickListener(v -> {
            Intent SignupIntent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(SignupIntent);
            finish();
        });

        btn_login.setOnClickListener(v -> {
            email = input_email.getText().toString().toLowerCase().trim();
            mdp = input_password.getText().toString().trim();
            if (validateInputs()) {
                login();
            }
        });
    }

    public void login() {
        displayLoader();
        queue = Volley.newRequestQueue(LoginActivity.this);
        final String url = "http://10.0.2.2:1225/getUser?email=" +  input_email.getText();
        //final String url = "http://192.168.1.102:1225/getUser?email=" +  input_email.getText();
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // response
                    if (!response.isEmpty()) {
                        try {
                            JSONObject c = new JSONObject(response);
                            User user = new User(
                                    c.getString("nom"),
                                    c.getString("email"),
                                    c.getString("mdp"),
                                    c.getString("genre"),
                                    c.getString("sexebebe"),
                                    c.getString("dateduterme")
                            );
                            if (user.getMdp().contentEquals(input_password.getText())) {
                                session.loginUser(user.getEmail(),user.getNom(),user.getDateterme(),user.getGenreuser(),user.getSexebebe());
                                loadDashboard();
                            } else {
                                pDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Password not correct", Toast.LENGTH_LONG).show();
                            }
                        } catch (final JSONException e) {
                            pDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Email invalid", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        pDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "User not found", Toast.LENGTH_LONG).show();
                    }
                },
                error -> {
                    // error
                    pDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Error connection server", Toast.LENGTH_LONG).show();
                }
        );
        queue.add(postRequest);
    }

    private void loadDashboard() {

        Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(i);
        finish();
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Logging In.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private boolean validateInputs() {
        if(KEY_EMPTY.equals(email)){
            input_email.setError("Email ne doit pas etre vide");
            input_email.requestFocus();
            return false;
        }
        if(KEY_EMPTY.equals(mdp)){
            input_password.setError("Mot de passe ne doit pas étre vide");
            input_password.requestFocus();
            return false;
        }
        return true;
    }




    /*public void login1() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(KEY_EMAIL, input_email);
            request.put(KEY_PASSWORD, input_password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, login_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        try {
                            //Check if user got logged in successfully

                            if (response.getInt(KEY_STATUS) == 0) {
                                session.loginUser(email,response.getString(KEY_EMAIL));
                                loadDashboard();

                            }else{
                                Toast.makeText(getApplicationContext(),
                                        response.getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }*/

}
