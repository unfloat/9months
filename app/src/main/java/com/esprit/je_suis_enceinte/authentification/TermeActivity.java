package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.esprit.je_suis_enceinte.MainActivity;
import com.esprit.je_suis_enceinte.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TermeActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();
    EditText dateterme;
    Button btn_calculer;

    private SharedPreferences mPreferences;
    public static final String sharedPrefFile= "com.esprit.je_suis_enceinte";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terme);

        dateterme = findViewById(R.id.dateterme);
        dateterme.setInputType(InputType.TYPE_NULL);
        dateterme.setText(getCurrentDate());

        mPreferences =  getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        dateterme.setText(mPreferences.getString("dateTerme",null));



        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                EditerDate();
            }

        };

        dateterme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(TermeActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn_calculer = findViewById(R.id.btn_calculer);
        btn_calculer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent CalculateurIntent = new Intent(TermeActivity.this, CalculateurActivity.class);
                startActivity(CalculateurIntent);
            }
        });

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
