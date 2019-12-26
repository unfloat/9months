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


public class hebdo8Fragment extends Fragment {

    private View thisView;
    TextView description;

    public hebdo8Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisView = inflater.inflate(R.layout.fragment_hebdo8, container, false);
        description = thisView.findViewById(R.id.descrip8);
        description.setMovementMethod(new ScrollingMovementMethod());
        return thisView;
    }

}