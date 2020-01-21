package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.esprit.je_suis_enceinte.MainActivity;
import com.esprit.je_suis_enceinte.NavigationActivity;
import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.bd.SessionHandler;
import com.esprit.je_suis_enceinte.entities.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TermeActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();
    EditText dateterme;
    User u;
    Button btn_calculer,btn_Commencer;
    private RequestQueue queue;
    String datet;

    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";


    private SharedPreferences mPreferences;
    public static final String sharedPrefFile= "com.esprit.je_suis_enceinte";
    private SessionHandler session;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new SessionHandler(getApplicationContext());
        setContentView(R.layout.activity_terme);


        dateterme = findViewById(R.id.dateterme);
        dateterme.setInputType(InputType.TYPE_NULL);
        dateterme.setText(getCurrentDate());

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        u = (User) bundle.getSerializable("user");

        mPreferences =  getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        dateterme.setText(mPreferences.getString("dateTerme",null));

        final DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            EditerDate();
        };

        dateterme.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            new DatePickerDialog(TermeActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        btn_calculer = findViewById(R.id.btn_calculer);
        btn_calculer.setOnClickListener(v -> {
            Intent CalculateurIntent = new Intent(TermeActivity.this, CalculateurActivity.class);
            startActivity(CalculateurIntent);
        });

        datet = dateterme.getText().toString().trim();
        u.setDateterme(datet);
        btn_Commencer = findViewById(R.id.btn_Commencer);
        btn_Commencer.setOnClickListener(v -> {
            displayLoader();
            queue = Volley.newRequestQueue(TermeActivity.this);
            final String url = "http://10.0.2.2:1225/getUser?email=" + u.getEmail();
            StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                    response -> {
                        // response
                        if (response.isEmpty()) {
                            session.loginUser(u.getEmail(),u.getNom(),u.getDateterme(),u.getGenreuser(),u.getSexebebe());
                            String url1 = "http://10.0.2.2:1225/AddUser?nom=" + u.getNom()
                                    + "&email=" + u.getEmail()
                                    + "&mdp=" + u.getMdp()
                                    + "&dateduterme=" + u.getDateterme()
                                    + "&genre=" + u.getGenreuser()
                                    + "&sexebebe=" + u.getSexebebe()
                                    ;
                            StringRequest postRequest1 = new StringRequest(Request.Method.POST, url1,
                                    response1 -> {
                                        // response
                                        Toast.makeText(TermeActivity.this, u.getEmail() + " added successfully", Toast.LENGTH_LONG).show();
                                        loadLogin();
                                    },
                                    error -> {
                                        // error
                                        Toast.makeText(TermeActivity.this, "Error connection server", Toast.LENGTH_LONG).show();
                                        pDialog.dismiss();
                                    }
                            );
                            queue.add(postRequest1);
                        } else {

                            Toast.makeText(TermeActivity.this, "User existes", Toast.LENGTH_LONG).show();
                            pDialog.dismiss();
                        }
                    },
                    error -> {
                        // error

                        Toast.makeText(TermeActivity.this, "Error connection server", Toast.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
            );
            queue.add(postRequest);

            Intent CommencerIntent = new Intent(TermeActivity.this, NavigationActivity.class);
            startActivity(CommencerIntent);
        });

    }

    private void loadLogin() {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(TermeActivity.this);
        pDialog.setMessage("Signing Up.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void EditerDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        dateterme.setText(sdf.format(myCalendar.getTime()));
    }

    public String getCurrentDate()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }
}
