package com.esprit.je_suis_enceinte.ui.Maman;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.je_suis_enceinte.NavigationActivity;
import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.fragments.CalendarFragment;
import com.esprit.je_suis_enceinte.Maman.Guide.GuideFragment;
import com.esprit.je_suis_enceinte.fragments.PrenomsFragment;


public class MamanFragment extends Fragment implements View.OnClickListener {
    private View thisView;
    private CardView cardView;
    private ViewGroup container;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_maman, container, false);
        this.container = container;
        cardView = thisView.findViewById(R.id.guides);
        cardView.setOnClickListener(this);
        return thisView;
    }

    @Override
    public void onClick(View v) {

        if (container != null) {
            container.removeAllViews();


            switch (v.getId()) {
                case R.id.guides:

                    ((NavigationActivity) getActivity()).loadFragment(new GuideFragment());

                    break;
                case R.id.calendarmaman:

                    ((NavigationActivity) getActivity()).loadFragment(new CalendarFragment());

                    break;
                case R.id.poids:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
                case R.id.ventre:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
                case R.id.stuff:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
                case R.id.food:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
            }
        }
    }
}





