package com.esprit.je_suis_enceinte.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.esprit.je_suis_enceinte.R;

public class GuideFragment extends Fragment  {

    private View thisView;
    private ViewGroup container;
    private CardView cardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragement_guide, container, false);
        return thisView;


    }

}
