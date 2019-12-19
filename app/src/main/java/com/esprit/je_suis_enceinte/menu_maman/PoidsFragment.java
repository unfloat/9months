package com.esprit.je_suis_enceinte.menu_maman;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.esprit.je_suis_enceinte.R;

public class PoidsFragment extends Fragment {
    private View view;



    public PoidsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragement_poids, container, false);
        return view;


    }
}


