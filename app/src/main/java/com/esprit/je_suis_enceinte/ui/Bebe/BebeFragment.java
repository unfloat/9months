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
import com.esprit.je_suis_enceinte.menu_bebe.CoupsFragment;
import com.esprit.je_suis_enceinte.menu_bebe.hebdomadaire.HebdomadaireFragment;
import com.esprit.je_suis_enceinte.menu_bebe.image.ImageFragment;
import com.esprit.je_suis_enceinte.menu_bebe.taille.TailleFragment;
import com.esprit.je_suis_enceinte.menu_maman.CalendarFragment;
import com.esprit.je_suis_enceinte.menu_bebe.PrenomsFragment;


public class BebeFragment extends Fragment implements View.OnClickListener {
    private View thisView;
    private Button menuPrenoms;
    private ViewGroup container;
    private CardView cardViewbib,cardViewcalendar,cardViewcoupe,cardViewtaille,cardViewimage,cardViewsac;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_bebe, container, false);
        this.container = container;

        cardViewbib = thisView.findViewById(R.id.bib);
        cardViewbib.setOnClickListener(this);

        cardViewcalendar = thisView.findViewById(R.id.calendar);
        cardViewcalendar.setOnClickListener(this);

        cardViewcoupe = thisView.findViewById(R.id.coupe);
        cardViewcoupe.setOnClickListener(this);

        cardViewtaille = thisView.findViewById(R.id.taille);
        cardViewtaille.setOnClickListener(this);

        cardViewimage = thisView.findViewById(R.id.image);
        cardViewimage.setOnClickListener(this);

        cardViewsac = thisView.findViewById(R.id.sac);
        cardViewsac.setOnClickListener(this);
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

                    ((NavigationActivity) getActivity()).loadFragment(new HebdomadaireFragment());

                    break;
                case R.id.coupe:

                    ((NavigationActivity) getActivity()).loadFragment(new CoupsFragment());

                    break;
                case R.id.taille:

                    ((NavigationActivity) getActivity()).loadFragment(new TailleFragment());

                    break;
                case R.id.image:

                    ((NavigationActivity) getActivity()).loadFragment(new ImageFragment());

                    break;
                case R.id.sac:

                    ((NavigationActivity) getActivity()).loadFragment(new PrenomsFragment());

                    break;
            }
        }
    }

}