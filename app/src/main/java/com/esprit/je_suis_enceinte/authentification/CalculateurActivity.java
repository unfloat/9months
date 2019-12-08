package com.esprit.je_suis_enceinte.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.esprit.je_suis_enceinte.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateurActivity extends AppCompatActivity {

    Calendar myCalendar = Calendar.getInstance();
    EditText dateregle;
    Button btn_ajouter;
    TextView textDate;

    public static final String sharedPrefFile= "com.esprit.je_suis_enceinte";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculateur);

        dateregle = findViewById(R.id.dateregle);
        dateregle.setInputType(InputType.TYPE_NULL);
        dateregle.setText(getCurrentDate());

        textDate = findViewById(R.id.textDate);
        textDate.setText(getCurrentDate());

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


        dateregle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(CalculateurActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn_ajouter = findViewById(R.id.btn_AjouterDate);
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(sharedPrefFile, 0).edit();
                editor.putString("dateTerme",textDate.getText().toString());
                editor.apply();
                editor.commit();

                Intent CalculateurIntent = new Intent(CalculateurActivity.this, TermeActivity.class);
                startActivity(CalculateurIntent);
            }
        });

    }

    private void EditerDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        dateregle.setText(sdf.format(myCalendar.getTime()));

        Calendar c = myCalendar;
        c.add(c.DAY_OF_MONTH,283);
        textDate.setText(sdf.format(c.getTime()));
        myCalendar = Calendar.getInstance();

    }

    public String getCurrentDate()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    /*-- Ajouter 9mois au date current---*/
    public String getCurrentDatePlus9mois()
    {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_WEEK, 268);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

}
