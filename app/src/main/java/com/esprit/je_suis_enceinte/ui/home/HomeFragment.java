package com.esprit.je_suis_enceinte.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.esprit.je_suis_enceinte.R;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View thisView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_home, container, false);
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