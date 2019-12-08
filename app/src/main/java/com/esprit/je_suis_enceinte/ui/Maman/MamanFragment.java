package com.esprit.je_suis_enceinte.ui.Maman;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esprit.je_suis_enceinte.R;


public class MamanFragment extends Fragment implements View.OnClickListener {
    private View thisView;
    private Button menuPrenoms;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_maman, container, false);

      //  menuPrenoms = (Button)thisView.findViewById(R.id.food);

        return thisView;

    }


    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.food:
                ((MainContainerActivity) getActivity()).loadFragment(new ListePrenomsFragment());
                break;

        }*/
    }

}