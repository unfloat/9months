package com.esprit.je_suis_enceinte.ui.Bebe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.esprit.je_suis_enceinte.NavigationActivity;
import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.fragments.CalendarFragment;
import com.esprit.je_suis_enceinte.fragments.PrenomsFragment;


public class BebeFragment extends Fragment implements View.OnClickListener {
    private View thisView;
    private Button menuPrenoms;
    private ViewGroup container;
    private CardView cardView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_bebe, container, false);
        this.container = container;
        cardView = thisView.findViewById(R.id.bib);
        cardView.setOnClickListener(this);
        return thisView;

    }


    @Override
    public void onClick(View v) {

        if (container != null) {
            container.removeAllViews();


            switch (v.getId()) {
                case R.id.bib:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
               case R.id.calendar:

                    ((NavigationActivity) getActivity()).loadFragment(new CalendarFragment());

                    break;
                case R.id.coupe:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
                case R.id.taille:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
                case R.id.image:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
                case R.id.food:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
            }
        }
    }

}