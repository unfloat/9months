package com.esprit.je_suis_enceinte.menu_maman.Guide.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.je_suis_enceinte.R;


public class TravailFragment extends Fragment {

    private View thisview;

    public TravailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        thisview = inflater.inflate(R.layout.fragment_travail, container, false);
        return thisview;
    }
}

    