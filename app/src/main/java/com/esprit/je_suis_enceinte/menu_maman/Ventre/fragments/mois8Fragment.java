package com.esprit.je_suis_enceinte.menu_maman.Ventre.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.je_suis_enceinte.R;

public class mois8Fragment extends Fragment {

    private View thisView;

    public mois8Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisView = inflater.inflate(R.layout.fragment_mois8, container, false);
        return thisView;
    }
}
