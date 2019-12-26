package com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.je_suis_enceinte.R;


public class hebdo3Fragment extends Fragment {

    private View thisvView;

    public hebdo3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisvView = inflater.inflate(R.layout.fragment_hebdo3, container, false);
        return thisvView;
    }
}
