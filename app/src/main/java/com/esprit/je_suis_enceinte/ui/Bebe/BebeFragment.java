package com.esprit.je_suis_enceinte.ui.Bebe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.esprit.je_suis_enceinte.R;


public class BebeFragment extends Fragment implements View.OnClickListener {
    private View thisView;
    private Button menuPrenoms;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_bebe, container, false);

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