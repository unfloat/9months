package com.esprit.je_suis_enceinte.menu_bebe.coups;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.esprit.je_suis_enceinte.R;
import android.os.CountDownTimer;

import java.util.Locale;


public class CoupsFragment extends Fragment {

    private View thisView;
    private Chronometer simpleChronometer;
    private TextView nbr_coups,title;
    private Button coups,btn_pause,btn_debut,btn_rest;
    private int compteur = 0;

    public CoupsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisView = inflater.inflate(R.layout.fragment_coups, container, false);

        coups = thisView.findViewById(R.id.coups);
        title = thisView.findViewById(R.id.title);
        btn_debut = thisView.findViewById(R.id.btn_debut);
        simpleChronometer = thisView.findViewById(R.id.simpleChronometer);
        nbr_coups = thisView.findViewById(R.id.nbr_coups);
        btn_pause = thisView.findViewById(R.id.btn_stop);
        btn_rest = thisView.findViewById(R.id.btn_rest);


        btn_debut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChronometer.start();
                title.setText("Appuyer sur le pied pour commencer à compter les coups");
                coups.setVisibility(View.VISIBLE);
                btn_pause.setVisibility(View.VISIBLE);
                btn_rest.setVisibility(View.VISIBLE);
                simpleChronometer.setVisibility(View.VISIBLE);
                nbr_coups.setVisibility(View.VISIBLE);
                btn_debut.setVisibility(View.INVISIBLE);
            }
        });

        coups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compteur++;
                nbr_coups.setText(Integer.toString(compteur));
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_pause.getText().equals("Pause"))
                {
                    Start();
                }else {
                    continuer();
                }
            }
        });

        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChronometer.setBase(SystemClock.elapsedRealtime());
                compteur=0;
                nbr_coups.setText(Integer.toString(compteur));
            }
        });

        return thisView;
    }

    private void Start() {
        simpleChronometer.stop();
        coups.setClickable(false);
        btn_pause.setText("Continuer");
    }

    private void continuer()
    {
        simpleChronometer.start();
        coups.setClickable(true);
        btn_pause.setText("Pause");

    }

}
