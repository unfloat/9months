package com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esprit.je_suis_enceinte.R;


public class hebdo1Fragment extends Fragment {

    private View thisview;
    TextView description;

    public hebdo1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisview = inflater.inflate(R.layout.fragment_hebdo1, container, false);
        description = thisview.findViewById(R.id.descrip1);
        description.setMovementMethod(new ScrollingMovementMethod());
        return thisview;
    }

}