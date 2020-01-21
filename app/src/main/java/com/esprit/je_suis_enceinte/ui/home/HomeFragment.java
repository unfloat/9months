package com.esprit.je_suis_enceinte.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.esprit.je_suis_enceinte.R;
import com.esprit.je_suis_enceinte.bd.SessionHandler;
import com.esprit.je_suis_enceinte.entities.User;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View thisView;
    private SessionHandler session;
    Context context;
    TextView welcomeText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisView = inflater.inflate(R.layout.fragment_home, container, false);

        session = new SessionHandler(thisView.getContext());
        User user = session.getUserDetails();
        welcomeText = thisView.findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome "+user.getEmail()+", your session "+user.getNom()+" will expire on "+user.getSessionExpiryDate()+" votre date du terme est "+user.getDateterme());

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